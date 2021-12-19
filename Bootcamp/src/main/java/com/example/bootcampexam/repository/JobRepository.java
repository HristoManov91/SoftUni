package com.example.bootcampexam.repository;

import com.example.bootcampexam.model.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<JobEntity , Long> {

    @Query("SELECT j FROM JobEntity j JOIN SkillEntity s WHERE s.name = ?1 ")
    Optional<List<JobEntity>> findAllJobsContainsSkill(String skillName);
}
