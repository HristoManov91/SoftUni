package com.example.bootcampexam.service;

import com.example.bootcampexam.model.entity.UserRoleEntity;
import com.example.bootcampexam.model.entity.enums.UserRoleEnum;

public interface UserRoleService {

    void initRoles();

    UserRoleEntity findByRole(UserRoleEnum role);
}
