package com.envio.email.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.ClassUtils;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "deleted=0")
public abstract class AbstractPersistableCustom<ID extends Serializable> implements Persistable<ID> {

    @Id
    @Column (nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    @JsonIgnore
    @Column(nullable = false)
    @Builder.Default
    private Long deleted = 0L;

    @JsonIgnore
    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private Long createdBy;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "modified_by", nullable = false)
    private Long modifiedBy;

    @JsonIgnore
    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy/MM/dd HH:mm:ss")
    private Date createdDate;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "modified_date", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy/MM/dd HH:mm:ss")
    private Date modifiedDate;

    public ID getId() {
        return id;
    }

    protected void setId(final ID Id) {
        this.id = Id;
    }

    public Long isDeleted() {
        return deleted;
    }

    public void setDeleted(Long deleted) {
        this.deleted = deleted;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Transient
    @JsonIgnore
    public boolean isNew() {
        return null == getId();
    }

    @Override
    public String toString() {
        return String.format("Entidade do tipo %s com id: %s", this.getClass().getName(), getId());
    }

    @Override
    public boolean equals(Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(ClassUtils.getUserClass(obj))) {
            return false;
        }

        AbstractPersistableCustom<?> that = (AbstractPersistableCustom<?>) obj;

        return null != this.getId() && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {

        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }

}
