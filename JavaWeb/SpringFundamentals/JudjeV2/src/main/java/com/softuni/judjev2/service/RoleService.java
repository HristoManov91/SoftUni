package com.softuni.judjev2.service;

import com.softuni.judjev2.model.entity.Role;
import com.softuni.judjev2.model.entity.RoleNameEnum;

public interface RoleService {
    void initRoles();

    Role findRole(RoleNameEnum roleNameEnum);
}
