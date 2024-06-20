package com.envio.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID Id);

    T findByIdSafe(ID Id);

    void delete(T entity);

    void deleteById(ID Id);

}