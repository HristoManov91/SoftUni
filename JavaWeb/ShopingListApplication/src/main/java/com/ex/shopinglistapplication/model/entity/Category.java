package com.ex.shopinglistapplication.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private CategoryEnum name;
    private String description;

    public Category() {
    }

    public Category(CategoryEnum categoryEnum , String description) {
        this.name = categoryEnum;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public CategoryEnum getName() {
        return name;
    }

    public Category setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    @Column(name = "description" , columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
