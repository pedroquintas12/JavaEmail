package com.envio.email.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Optional<T> findById(ID id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
        Root<T> root = cQuery.from(getDomainClass());
        cQuery.select(root).where(
                builder.equal(root.<String>get("id"), id),
                builder.or(
                        builder.equal(root.<String>get("deleted"), 0L),
                        builder.isNull(root.<String>get("deleted"))
                ));
        TypedQuery<T> query = entityManager.createQuery(cQuery);
        T result;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            result = null;
        }
        return Optional.ofNullable(result);
    }

    @Transactional
    @Override
    public T findByIdSafe(ID id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
        Root<T> root = cQuery.from(getDomainClass());
        cQuery.select(root).where(
                builder.equal(root.<String>get("id"), id),
                builder.or(
                        builder.equal(root.<String>get("deleted"), 0L),
                        builder.isNull(root.<String>get("deleted"))
                ));
        TypedQuery<T> query = entityManager.createQuery(cQuery);
        T result = query.getSingleResult();
        return Optional.ofNullable(result).orElseThrow(() -> new RuntimeException(getDomainClass() + " não localizado para esse id " + id));
    }

    @Transactional
    @Override
    public List<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
        Root<T> root = cQuery.from(getDomainClass());
        // cQuery.select(root).where(builder.equal(root.<String>get("deleted"), 0L));
        cQuery.select(root).where(builder.or(builder.equal(root.<String>get("deleted"), 0L),
                builder.isNull(root.<String>get("deleted"))));
        TypedQuery<T> query = entityManager.createQuery(cQuery);
        return query.getResultList();
    }

    @Transactional
    @Override
    @SuppressWarnings("JavaReflectionInvocation")
    public void delete(T entity) {
        try {
            // Entidade e pah
            Method del = entity.getClass().getMethod("setDeleted", Long.class);
            Method getid = entity.getClass().getMethod("getId");
            ID id = (ID) getid.invoke(entity);
            del.invoke(entity, id);
            save(entity);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                 | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    @Override
    public void deleteById(ID id) {
        Optional<T> obj = findById(id);
        obj.ifPresent(this::delete);
    }

}
