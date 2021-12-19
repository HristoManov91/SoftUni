package com.example.bootcampexam.repository;

import com.example.bootcampexam.model.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long> {

    Optional<SkillEntity> findByName(String name);
}
