package com.example.mobilele.model.binding;

import com.example.mobilele.model.entity.UserRoleEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotBlank
    @Length(min = 2 , max = 15 , message = "First name length must be between 2 and 15 characters!")
    private String firstName;
    @NotBlank
    @Length(min = 2 , max = 15 , message = "Last name length must be between 2 and 15 characters!")
    private String lastName;
    @NotBlank
    @Length(min = 2 , max = 15 , message = "Username length must be between 2 and 15 characters!")
    private String username;
    @NotBlank
    @Length(min = 2 , max = 15 , message = "Password length must be between 2 and 15 characters!")
    private String password;
    @NotNull
    @Size(min = 4 , max = 20 , message = "Password length must be between 2 and 15 characters!")
    private String confirmPassword;


    public UserRegisterBindingModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
