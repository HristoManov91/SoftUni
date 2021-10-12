package com.example.mobilele.service;

import com.example.mobilele.model.entity.UserEntity;
import com.example.mobilele.model.entity.UserRoleEntity;
import com.example.mobilele.model.service.UserLoginServiceModel;
import com.example.mobilele.model.service.UserServiceModel;

import java.util.List;

public interface UserService {

    void saveUser(UserServiceModel userServiceModel);

    UserEntity findUserById(Long id);

    boolean login(UserLoginServiceModel user);

    boolean usernameExist(String username);
}
