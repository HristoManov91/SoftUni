package com.ex.shopinglistapplication.service.impl;

import com.ex.shopinglistapplication.model.binding.UserRegisterBindingModel;
import com.ex.shopinglistapplication.model.entity.User;
import com.ex.shopinglistapplication.model.service.UserServiceModel;
import com.ex.shopinglistapplication.repository.UserRepository;
import com.ex.shopinglistapplication.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        userRepository.save(user);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user , UserServiceModel.class))
                .orElse(null);
    }
}
