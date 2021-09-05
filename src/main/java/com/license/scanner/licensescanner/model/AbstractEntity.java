package com.license.scanner.licensescanner.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;


@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Column(name ="created_at", updatable = false)
    @CreationTimestamp
    protected  Timestamp createdAt;


    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    protected Timestamp updatedAt;
}
