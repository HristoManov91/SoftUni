package com.springdata.springdataadvancedqueriyng.dao;

import com.springdata.springdataadvancedqueriyng.entity.Label;
import com.springdata.springdataadvancedqueriyng.entity.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
}
