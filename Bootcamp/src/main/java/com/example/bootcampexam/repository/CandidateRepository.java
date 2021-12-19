package com.example.bootcampexam.repository;

import com.example.bootcampexam.model.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity , Long> {
}
