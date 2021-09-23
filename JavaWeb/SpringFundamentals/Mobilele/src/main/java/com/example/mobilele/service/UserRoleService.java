package com.example.mobilele.service;

import com.example.mobilele.model.entity.UserRoleEntity;
import com.example.mobilele.model.entity.enums.UserRoleEnum;

public interface UserRoleService {
    void initRoles();

    Long size();

    UserRoleEntity findRoleByName(UserRoleEnum userRoleEnum);


}
