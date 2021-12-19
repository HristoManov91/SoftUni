package com.example.bootcampexam.init;

import com.example.bootcampexam.service.UserRoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final UserRoleService userRoleService;

    public DataInit(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public void run(String... args) throws Exception {
        userRoleService.initRoles();
    }
}
