package com.example.exam.repository;

import com.example.exam.model.entity.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity , Long> {

    List<ShipEntity> findAllByUserEntity_Username(String username);

    @Query("SELECT s FROM ShipEntity s WHERE s.userEntity.username not like ?1 ")
    List<ShipEntity> findAllByUserEntity_UsernameNotEquals(String username);

    ShipEntity findByName(String shipName);
}
