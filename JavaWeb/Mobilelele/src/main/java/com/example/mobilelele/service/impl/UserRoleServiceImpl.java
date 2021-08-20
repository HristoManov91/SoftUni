package com.example.mobilelele.service.impl;

import com.example.mobilelele.model.entity.Role;
import com.example.mobilelele.model.entity.User;
import com.example.mobilelele.model.entity.UserRole;
import com.example.mobilelele.repository.UserRoleRepository;
import com.example.mobilelele.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initRoles() {
        UserRole userRole = new UserRole().setRole(Role.USER);
        userRoleRepository.save(userRole);
        UserRole adminRole = new UserRole().setRole(Role.ADMIN);
        userRoleRepository.save(adminRole);
    }

    @Override
    public long count() {
        return userRoleRepository.count();
    }

    @Override
    public UserRole getRoleAdmin() {
        return userRoleRepository.getById(1L);
    }

    @Override
    public UserRole getRoleUser() {
        return userRoleRepository.getById(2L);
    }


}
