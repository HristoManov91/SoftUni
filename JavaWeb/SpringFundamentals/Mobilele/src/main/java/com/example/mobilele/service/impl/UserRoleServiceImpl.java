package com.example.mobilele.service.impl;

import com.example.mobilele.model.entity.UserRoleEntity;
import com.example.mobilele.model.entity.enums.UserRoleEnum;
import com.example.mobilele.repository.UserRoleRepository;
import com.example.mobilele.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initRoles() {
        if(userRoleRepository.count() == 0){
            UserRoleEntity user = new UserRoleEntity().setRole(UserRoleEnum.USER);
            UserRoleEntity admin = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
            userRoleRepository.save(user);
            userRoleRepository.save(admin);
        }
    }

    @Override
    public Long size() {
        return userRoleRepository.count();
    }

    @Override
    public UserRoleEntity findRoleByName(UserRoleEnum userRoleEnum) {
        return userRoleRepository.findByRole(userRoleEnum);
    }
}
