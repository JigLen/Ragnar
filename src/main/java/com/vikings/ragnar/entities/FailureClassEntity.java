package com.vikings.ragnar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 17/02/2017.
 */
@Entity
@Table(name="failure_class")
public class FailureClassEntity implements Serializable{
    @Id @Column(name="Failure_Class") private Integer failureClass;
    @Column(name="Description") private String description;

    public FailureClassEntity() {
    }

    public FailureClassEntity(Integer failureClass) {
        this.failureClass = failureClass;
    }

    public FailureClassEntity(Integer failureClass, String description) {
        this.failureClass = failureClass;
        this.description = description;
    }

    public Integer getFailureClass() {
        return failureClass;
    }

    public void setFailureClass(Integer failureClass) {
        this.failureClass = failureClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
