package com.example.exam.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @Size(min = 3 , max = 10 , message = "Username length be between 3 and 10 characters.")
    @NotBlank(message = "Username cannot be empty string")
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Size(min = 3 , message = "Password length must be more than 3 characters.")
    @NotBlank(message = "Password cannot be empty string")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
