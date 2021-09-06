package com.ex.shopinglistapplication.repository;

import com.ex.shopinglistapplication.model.entity.User;
import com.ex.shopinglistapplication.model.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User , String> {

    Optional<User> findByUsernameAndPassword(String username, String password);
}
