package com.example.mobilele.service.impl;

import com.example.mobilele.model.entity.UserEntity;
import com.example.mobilele.model.service.UserLoginServiceModel;
import com.example.mobilele.model.service.UserServiceModel;
import com.example.mobilele.repository.UserRepository;
import com.example.mobilele.security.CurrentUser;
import com.example.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void saveUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        userRepository.save(user);
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean login(UserLoginServiceModel user) {
        Optional<UserEntity> userEntity = userRepository.findUserEntityByUsername(user.getUsername());

        if (userEntity.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success = passwordEncoder.matches(user.getRawPassword(), userEntity.get().getPassword());

            if (success) {
                UserEntity loggedInUser = userEntity.get();
                login(loggedInUser);

                loggedInUser.getRoles().forEach(r -> currentUser.addRole(r.getRole()));
            }

            return success;
        }
    }

    private void login(UserEntity loggedInUser) {
        currentUser
                .setLoggedIn(true)
                .setFirstName(loggedInUser.getFirstName())
                .setLastName(loggedInUser.getLastName())
                .setUsername(loggedInUser.getUsername());
    }

    private void logout() {
        //ToDo
    }

    @Override
    public boolean usernameExist(String username) {
        return userRepository.existsUserEntityByUsername(username);
    }
}
