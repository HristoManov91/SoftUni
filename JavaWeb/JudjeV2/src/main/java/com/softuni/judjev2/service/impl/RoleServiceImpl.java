package com.softuni.judjev2.service.impl;

import com.softuni.judjev2.model.entity.Role;
import com.softuni.judjev2.model.entity.RoleNameEnum;
import com.softuni.judjev2.repository.RoleRepository;
import com.softuni.judjev2.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if(roleRepository.count() == 0){
            Role admin = new Role(RoleNameEnum.ADMIN);
            Role user = new Role(RoleNameEnum.USER);
            roleRepository.save(admin);
            roleRepository.save(user);
        }
    }
}
