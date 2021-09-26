package com.example.mobilele.model.service;

import com.example.mobilele.model.entity.UserRoleEntity;

public class UserServiceModel {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private UserRoleEntity role;

    public UserServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public UserServiceModel setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public UserRoleEntity getRole() {
        return role;
    }

    public UserServiceModel setRole(UserRoleEntity role) {
        this.role = role;
        return this;
    }
}
