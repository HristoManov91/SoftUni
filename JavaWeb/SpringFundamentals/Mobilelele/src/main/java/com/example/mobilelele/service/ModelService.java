package com.example.mobilelele.service;

import com.example.mobilelele.model.entity.Model;

import java.time.Instant;

public interface ModelService {

    void addModel(String name , String category , String imageUrl , Integer startYear , Long brandId);

    Model findById(Long id);
}
