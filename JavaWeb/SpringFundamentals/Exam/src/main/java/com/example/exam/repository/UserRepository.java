package com.example.exam.repository;

import com.example.exam.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity , Long> {

    Optional<UserEntity> findUserEntityByUsernameAndPassword(String username, String password);

    UserEntity findUserEntityByUsername(String username);
}
