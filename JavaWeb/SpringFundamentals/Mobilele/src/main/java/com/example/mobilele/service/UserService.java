package com.example.mobilele.service;

import com.example.mobilele.model.entity.UserEntity;

public interface UserService {

    void saveUser(UserEntity userEntity);

    UserEntity findUserById(Long id);

    boolean login(String username , String password);
}
