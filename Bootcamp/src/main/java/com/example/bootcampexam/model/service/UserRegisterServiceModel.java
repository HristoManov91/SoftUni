package com.example.bootcampexam.model.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterServiceModel {

    private String username;
    private String password;
    private String email;

    public UserRegisterServiceModel() {
    }

    @NotBlank(message = "Username can not be empty!")
    @Size(min = 6, max = 20 , message = "Username length should be between 6 and 20 characters!")
    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank(message = "Password can not be empty!")
    @Size(min = 8, max = 20 , message = "Password length should be between 8 and 20 characters!")
    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Email(message = "Enter valid email address!")
    public String getEmail() {
        return email;
    }

    public UserRegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
