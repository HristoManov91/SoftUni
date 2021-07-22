package com.example.xmlex.service.impl;

import com.example.xmlex.model.dto.productDto.ProductViewWithBuyerDto;
import com.example.xmlex.model.dto.userDto.UserSeedDto;
import com.example.xmlex.model.dto.userDto.UserViewRootDto;
import com.example.xmlex.model.dto.userDto.UserWithSoldProducts;
import com.example.xmlex.model.entity.User;
import com.example.xmlex.repository.UserRepository;
import com.example.xmlex.service.UserService;
import com.example.xmlex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public long getCount() {
        return userRepository.count();
    }

    @Override
    public void seedUsers(List<UserSeedDto> users) {
        users.stream()
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public User getRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);

        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public UserViewRootDto findAllUsersWithMoreThanOneSoldProduct() {
        UserViewRootDto userViewRootDto = new UserViewRootDto();

        userViewRootDto.setUsers(userRepository.findAllUsersWithMoreThanOneSoldProduct()
                .stream()
                .map(user -> modelMapper.map(user , UserWithSoldProducts.class)
//                    UserWithSoldProducts map = modelMapper.map(user, UserWithSoldProducts.class);
//                    map.setProducts(user.getProducts()
//                            .stream()
//                            .map(product -> modelMapper.map(product, ProductViewWithBuyerDto.class))
//                            .collect(Collectors.toSet()));
//
//                    return map;
                )
                .collect(Collectors.toList()));

        return userViewRootDto;
    }
}
