package com.example.mobilelele.service;

import com.example.mobilelele.model.entity.User;

public interface UserService {

    void saveUser(User user);

    void loginUser(String userName);

    void logoutCurrentUser();

    boolean authenticate(String username , String password);

    User findByUsername(String name);
}

