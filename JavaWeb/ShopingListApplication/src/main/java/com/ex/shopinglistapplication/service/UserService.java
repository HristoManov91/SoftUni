package com.ex.shopinglistapplication.service;

import com.ex.shopinglistapplication.model.binding.UserRegisterBindingModel;
import com.ex.shopinglistapplication.model.service.UserServiceModel;

public interface UserService {
    Boolean register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
