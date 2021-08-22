package com.softuni.judjev2.service.impl;

import com.softuni.judjev2.model.entity.RoleNameEnum;
import com.softuni.judjev2.model.entity.User;
import com.softuni.judjev2.model.service.UserServiceModel;
import com.softuni.judjev2.repository.UserRepository;
import com.softuni.judjev2.security.CurrentUser;
import com.softuni.judjev2.service.RoleService;
import com.softuni.judjev2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel , User.class);
        user.setRole(roleService.findRole(RoleNameEnum.USER));
        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user , UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser
                .setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername())
                .setRole(userServiceModel.getRole().getName());
    }

    @Override
    public void logout() {
        currentUser
                .setId(null)
                .setUsername(null)
                .setRole(null);
    }

    @Override
    public List<String> findAllUsernames() {
        return userRepository.findAllUsernames();
    }

    @Override
    public void changeRole(String username, RoleNameEnum roleNameEnum) {
        User user = userRepository.findByUsername(username).orElse(null);

        if (user != null && user.getRole().getName() != roleNameEnum) {
            user.setRole(roleService.findRole(roleNameEnum));

            userRepository.save(user);
        }
    }
}
