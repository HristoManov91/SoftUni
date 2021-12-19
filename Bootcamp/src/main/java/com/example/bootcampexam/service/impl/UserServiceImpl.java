package com.example.bootcampexam.service.impl;

import com.example.bootcampexam.model.entity.UserEntity;
import com.example.bootcampexam.model.entity.enums.UserRoleEnum;
import com.example.bootcampexam.model.service.UserRegisterServiceModel;
import com.example.bootcampexam.repository.UserRepository;
import com.example.bootcampexam.service.UserRoleService;
import com.example.bootcampexam.service.UserService;
import com.example.bootcampexam.web.exception.ObjectNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserEntity registerUser(UserRegisterServiceModel userServiceModel) {
        UserEntity user = new UserEntity()
                .setUsername(userServiceModel.getUsername())
                .setPassword(passwordEncoder.encode(userServiceModel.getPassword()))
                .setEmail(userServiceModel.getEmail())
                .setRoles(List.of(userRoleService.findByRole(UserRoleEnum.USER)));

        return userRepository.save(user);
    }

    @Override
    public UserEntity findUserByUsername(String username) {

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with this " + username + " username not found!"));
    }

    @Override
    public boolean usernameExist(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean emailExist(String email) {
        return userRepository.existsByEmail(email);
    }
}
