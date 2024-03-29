package com.example.mobilele.model.service;

import com.example.mobilele.model.entity.enums.UserRoleEnum;

import java.time.Instant;

public class UserRegisterServiceModel {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public UserRegisterServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
