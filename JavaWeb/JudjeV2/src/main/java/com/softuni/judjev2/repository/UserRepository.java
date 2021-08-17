package com.softuni.judjev2.repository;

import com.softuni.judjev2.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    Optional<User> findByUsernameAndPassword(String username , String password);
}
