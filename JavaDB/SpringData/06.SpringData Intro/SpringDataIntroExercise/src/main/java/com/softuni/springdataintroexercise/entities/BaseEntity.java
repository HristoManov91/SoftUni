package com.softuni.springdataintroexercise.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass //всички наследници ще имат id (за да не го пишем отделно във всеки клас
public abstract class BaseEntity {
    private long id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//така самичко се сеща да си прави AutoIncrement
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
