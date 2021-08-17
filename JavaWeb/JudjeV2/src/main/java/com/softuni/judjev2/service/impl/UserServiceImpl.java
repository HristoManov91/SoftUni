package com.softuni.judjev2.service.impl;

import com.softuni.judjev2.model.entity.RoleNameEnum;
import com.softuni.judjev2.model.entity.User;
import com.softuni.judjev2.model.service.UserServiceModel;
import com.softuni.judjev2.repository.UserRepository;
import com.softuni.judjev2.service.RoleService;
import com.softuni.judjev2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel , User.class);
        user.setRole(roleService.findRole(RoleNameEnum.USER));
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user , UserServiceModel.class))
                .orElse(null);
    }
}
