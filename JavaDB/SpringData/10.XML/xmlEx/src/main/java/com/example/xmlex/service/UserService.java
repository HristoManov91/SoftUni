package com.example.xmlex.service;

import com.example.xmlex.model.dto.userDto.UserSeedDto;
import com.example.xmlex.model.dto.userDto.UserViewRootDto;
import com.example.xmlex.model.entity.User;

import java.util.List;

public interface UserService {
    long getCount();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UserViewRootDto findAllUsersWithMoreThanOneSoldProduct();
}
