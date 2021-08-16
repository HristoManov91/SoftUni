package com.softuni.judjev2.repository;

import com.softuni.judjev2.model.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise , Long> {
}
