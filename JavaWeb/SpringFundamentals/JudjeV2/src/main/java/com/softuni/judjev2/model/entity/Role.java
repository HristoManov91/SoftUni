package com.softuni.judjev2.model.entity;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private RoleNameEnum name;

    public Role() {
    }

    public Role(RoleNameEnum name) {
        this.name = name;
    }

    public RoleNameEnum getName() {
        return name;
    }

    public Role setName(RoleNameEnum name) {
        this.name = name;
        return this;
    }
}
