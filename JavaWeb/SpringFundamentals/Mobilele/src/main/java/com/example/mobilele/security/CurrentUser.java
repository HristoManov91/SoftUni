package com.example.mobilele.security;

import com.example.mobilele.model.entity.UserRoleEntity;
import com.example.mobilele.model.entity.enums.UserRoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private Long id;
    private String username;
    private UserRoleEntity role;

    public CurrentUser() {
    }

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserRoleEntity getRole() {
        return role;
    }

    public CurrentUser setRole(UserRoleEntity role) {
        this.role = role;
        return this;
    }

    public boolean isAnonymous(){
        return this.username == null;
    }

    public boolean isAdmin(){
        return this.role.getRole() == UserRoleEnum.ADMIN;
    }
}
