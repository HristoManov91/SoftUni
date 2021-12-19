package com.example.bootcampexam.model.entity;

import com.example.bootcampexam.model.entity.enums.UserRoleEnum;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {

    private UserRoleEnum role;
    private String description;

    public UserRoleEntity() {
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public UserRoleEntity setRole(UserRoleEnum role) {
        this.role = role;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UserRoleEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
