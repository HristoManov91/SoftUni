package com.example.mobilele.service;

import com.example.mobilele.model.entity.UserEntity;
import com.example.mobilele.model.service.UserLoginServiceModel;
import com.example.mobilele.model.service.UserRegisterServiceModel;

public interface UserService {

    UserEntity findUserById(Long id);

    boolean login(UserLoginServiceModel user);

    boolean usernameExist(String username);

    void logout();

    void registerAndLoginUser(UserRegisterServiceModel serviceModel);

    void saveUser(UserEntity admin);
}
