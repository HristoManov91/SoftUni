package com.example.jsonex.service.impl;

import com.example.jsonex.model.dto.*;
import com.example.jsonex.model.entity.User;
import com.example.jsonex.repository.UserRepository;
import com.example.jsonex.service.UserService;
import com.example.jsonex.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final String PATH_TO_USERS_FILE = "src/main/resources/files/users.json";
    private final UserRepository userRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers() throws IOException {
        if (userRepository.count() > 0) {
            return;
        }
        String contentFile = Files.readString(Path.of(PATH_TO_USERS_FILE));

        Arrays.stream(gson.fromJson(contentFile, UserSeedDto[].class))
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);

        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<UserSoldDto> findAllUsersWithMoreThanOneSoldProducts() {
        List<UserSoldDto> collect = userRepository.findAllUsersWithMoreThanOneSoldProductsOrderByLastNameThanFirstName()
                .stream()
                .map(user -> {
                    UserSoldDto map = modelMapper.map(user, UserSoldDto.class);
                    map.setSoldProducts(user.getProducts().stream().map(product ->
                            modelMapper.map(product, ProductWithBuyerDto.class)).collect(Collectors.toSet()));

                    return map;
                })
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public UserCountAndProductsDto usersAndSoldProductsInfo() {
        Set<UserWithProductsSoldDto> users = userRepository.findAllUserWithMoreThanOneSoldProductsOrderByCountOfProductsSoldThanByLastName()
                .stream()
                .map(user -> {
                    UserWithProductsSoldDto mapUser = modelMapper.map(user, UserWithProductsSoldDto.class);
                    mapUser.setSoldProducts(user.getProducts().stream().map(product -> {
                        SoldProductDto mapProduct = modelMapper.map(product, SoldProductDto.class);
                        mapProduct.setCount((long) user.getProducts().size());
                        mapProduct.setProducts(user.getProducts().stream().map(product1 -> modelMapper.map(product1, ProductSeedDto.class)).collect(Collectors.toSet()));
                        return mapProduct;
                    }).collect(Collectors.toSet()));

                    return mapUser;
                })
                .collect(Collectors.toSet());

        UserCountAndProductsDto map = modelMapper.map(users, UserCountAndProductsDto.class);
        map.setCount((long) users.size());
        map.setUsers(users);
        return map;
    }
}
