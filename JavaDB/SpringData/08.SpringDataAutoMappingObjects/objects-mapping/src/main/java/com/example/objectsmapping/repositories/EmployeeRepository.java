package com.example.objectsmapping.repositories;

import com.example.objectsmapping.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {
}
