package com.example.bootcampexam.service;

import com.example.bootcampexam.model.entity.RecruiterEntity;

public interface RecruiterService {

    RecruiterEntity findByEmail(String email , String country , String lastName);
}
