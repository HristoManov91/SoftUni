package com.example.mobilelele.repository;

import com.example.mobilelele.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    User findByUsername(String username);
}
