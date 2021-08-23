package com.softuni.judjev2.service;

import com.softuni.judjev2.model.entity.RoleNameEnum;
import com.softuni.judjev2.model.entity.User;
import com.softuni.judjev2.model.service.UserServiceModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();

    List<String> findAllUsernames();

    void changeRole(String username, RoleNameEnum role);

    User findByName(String username);
}

