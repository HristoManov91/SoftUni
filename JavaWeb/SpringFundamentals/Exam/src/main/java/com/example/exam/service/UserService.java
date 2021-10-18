package com.example.exam.service;

import com.example.exam.model.entity.UserEntity;
import com.example.exam.model.service.UserRegistrationServiceModel;
import com.example.exam.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserRegistrationServiceModel userModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserEntity findById(Long id);

    UserEntity findByUsername(String username);
}
