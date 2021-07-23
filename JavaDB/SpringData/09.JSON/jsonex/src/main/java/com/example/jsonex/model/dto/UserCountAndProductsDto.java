package com.example.jsonex.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserCountAndProductsDto {

    @Expose
    private Long count;
    @Expose
    private Set<UserWithProductsSoldDto> users;

    public UserCountAndProductsDto() {
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Set<UserWithProductsSoldDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserWithProductsSoldDto> users) {
        this.users = users;
    }
}
