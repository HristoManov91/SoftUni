package com.example.springbootintro.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "brands")
public class Brand extends BaseEntity {

    @Column (nullable = false)
    private String name;

    public Brand() {
    }

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }
}
