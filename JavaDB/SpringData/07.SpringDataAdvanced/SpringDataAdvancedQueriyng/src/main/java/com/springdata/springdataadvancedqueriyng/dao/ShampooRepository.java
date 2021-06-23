package com.springdata.springdataadvancedqueriyng.dao;

import com.springdata.springdataadvancedqueriyng.entity.Shampoo;
import com.springdata.springdataadvancedqueriyng.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo , Long> {
    List<Shampoo> findBySizeOrderById(Size size);
}
