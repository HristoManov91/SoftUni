package com.example.bootcampexam.service.impl;

import com.example.bootcampexam.model.entity.UserRoleEntity;
import com.example.bootcampexam.model.entity.enums.UserRoleEnum;
import com.example.bootcampexam.repository.UserRoleRepository;
import com.example.bootcampexam.service.UserRoleService;
import com.example.bootcampexam.web.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initRoles() {
        //ToDo add valid description for roles
        if (userRoleRepository.count() == 0){
            UserRoleEntity admin = new UserRoleEntity().setRole(UserRoleEnum.ADMIN).setDescription("Description for Admin");
            userRoleRepository.save(admin);
            UserRoleEntity moderator = new UserRoleEntity().setRole(UserRoleEnum.ADMIN).setDescription("Description for Moderator");
            userRoleRepository.save(moderator);
            UserRoleEntity user = new UserRoleEntity().setRole(UserRoleEnum.ADMIN).setDescription("Description for User");
            userRoleRepository.save(user);
        }
    }

    @Override
    public UserRoleEntity findByRole(UserRoleEnum role) {
        return userRoleRepository.findByRole(role)
                .orElseThrow(() -> new ObjectNotFoundException("Role with this param not found"));
    }
}
