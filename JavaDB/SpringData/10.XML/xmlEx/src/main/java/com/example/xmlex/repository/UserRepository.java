package com.example.xmlex.repository;

import com.example.xmlex.model.entity.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Registered
public interface UserRepository extends JpaRepository<User , Long> {

    @Query ("SELECT u FROM User u " +
            "WHERE (SELECT COUNT(p) FROM Product p WHERE p.seller.id = u.id AND p.buyer IS NOT NULL ) > 0 " +
            "ORDER BY u.lastName , u.firstName")
    List<User> findAllUsersWithMoreThanOneSoldProduct();
}
