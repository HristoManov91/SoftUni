package com.example.mobilelele.service;

import com.example.mobilelele.model.entity.User;
import com.example.mobilelele.model.entity.UserRole;

public interface UserRoleService {

    void initRoles();

    long count();

    UserRole getRoleAdmin();

    UserRole getRoleUser();
}
