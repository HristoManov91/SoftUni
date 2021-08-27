package com.example.mobilelele.service.impl;

import com.example.mobilelele.model.entity.User;
import com.example.mobilelele.repository.UserRepository;
import com.example.mobilelele.security.CurrentUser;
import com.example.mobilelele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void loginUser(String username) {
        User user = userRepository.findByUsername(username);
        
        currentUser.setAnonymous(false).setName(user.getUsername());
    }

    @Override
    public void logoutCurrentUser() {
        currentUser.setAnonymous(true);
    }

    @Override
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);

        if(user == null){
            return false;
        } else {
            return passwordEncoder.matches(password , user.getPassword());
        }
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }
}
