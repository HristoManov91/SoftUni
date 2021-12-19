package com.example.bootcampexam.repository;

import com.example.bootcampexam.model.entity.RecruiterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterEntity , Long> {

    Optional<RecruiterEntity> findByEmail(String email);
}
