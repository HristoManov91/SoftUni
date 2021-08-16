package com.softuni.judjev2.service.impl;

import com.softuni.judjev2.repository.UserRepository;
import com.softuni.judjev2.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
