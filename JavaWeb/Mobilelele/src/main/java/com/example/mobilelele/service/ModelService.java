package com.example.mobilelele.service;

import java.time.Instant;

public interface ModelService {

    void addModel(String name , Instant created , String category , String imageUrl , Integer startYear , Long brandId);
}
