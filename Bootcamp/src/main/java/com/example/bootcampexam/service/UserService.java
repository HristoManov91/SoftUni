package com.example.bootcampexam.service;

import com.example.bootcampexam.model.entity.UserEntity;
import com.example.bootcampexam.model.service.UserRegisterServiceModel;

public interface UserService {
    
    UserEntity registerUser(UserRegisterServiceModel userServiceModel);

    UserEntity findUserByUsername(String username);

    boolean usernameExist(String username);

    boolean emailExist(String email);
}
