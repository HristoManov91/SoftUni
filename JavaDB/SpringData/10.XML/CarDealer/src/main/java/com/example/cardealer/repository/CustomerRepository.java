package com.example.cardealer.repository;

import com.example.cardealer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {

    @Query ("SELECT c FROM Customer c ORDER BY c.birthDate ")
    List<Customer> findAllCustomerOrderByBirthDateThanByYoungDriver();
}
