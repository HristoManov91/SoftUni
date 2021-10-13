package com.example.mobilele.service.impl;

import com.example.mobilele.model.entity.UserEntity;
import com.example.mobilele.model.entity.UserRoleEntity;
import com.example.mobilele.model.entity.enums.UserRoleEnum;
import com.example.mobilele.model.service.UserLoginServiceModel;
import com.example.mobilele.model.service.UserRegisterServiceModel;
import com.example.mobilele.repository.UserRepository;
import com.example.mobilele.repository.UserRoleRepository;
import com.example.mobilele.security.CurrentUser;
import com.example.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean login(UserLoginServiceModel user) {
        Optional<UserEntity> userEntity = userRepository.findUserEntityByUsername(user.getUsername());

        if (userEntity.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success = passwordEncoder.matches(user.getRawPassword(), userEntity.get().getPassword());

            if (success) {
                UserEntity loggedInUser = userEntity.get();
                login(loggedInUser);

                loggedInUser.getRoles().forEach(r -> currentUser.addRole(r.getRole()));
            }

            return success;
        }
    }

    private void login(UserEntity loggedInUser) {
        currentUser
                .setLoggedIn(true)
                .setFirstName(loggedInUser.getFirstName())
                .setLastName(loggedInUser.getLastName())
                .setUsername(loggedInUser.getUsername());
    }

    @Override
    public void logout() {
        currentUser.clean();
    }

    @Override
    public void registerAndLoginUser(UserRegisterServiceModel serviceModel) {
        UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER);

        UserEntity user = new UserEntity();

        user
                .setActive(true)
                .setFirstName(serviceModel.getFirstName())
                .setLastName(serviceModel.getLastName())
                .setUsername(serviceModel.getUsername())
                .setPassword(passwordEncoder.encode(serviceModel.getPassword()))
                .setRoles(Set.of(userRole));

        user = userRepository.save(user);

        login(user);
    }

    @Override
    public void saveUser(UserEntity admin) {
        userRepository.save(admin);
    }

    @Override
    public boolean usernameExist(String username) {
        return userRepository.existsUserEntityByUsername(username);
    }
}
