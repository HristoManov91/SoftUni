package com.example.exam.service.impl;

import com.example.exam.model.entity.UserEntity;
import com.example.exam.model.service.UserRegistrationServiceModel;
import com.example.exam.model.service.UserServiceModel;
import com.example.exam.repository.UserRepository;
import com.example.exam.service.UserService;
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
    public void registerUser(UserRegistrationServiceModel userModel) {

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(userModel.getUsername())
                .setEmail(userModel.getEmail())
                .setPassword(userModel.getPassword())
                .setFullName(userModel.getFullName());

        userRepository.save(userEntity);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findUserEntityByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user , UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findUserEntityByUsername(username);
    }
}
