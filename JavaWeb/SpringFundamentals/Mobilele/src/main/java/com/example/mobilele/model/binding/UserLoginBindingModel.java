package com.example.mobilele.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    @NotBlank
    @Length(min = 2 , max = 15 , message = "Username length must be between 2 and 15 characters!")
    private String username;
    @NotBlank
    @Size(min = 2 , max = 15 , message = "Password length must be between 2 and 15 characters!")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
