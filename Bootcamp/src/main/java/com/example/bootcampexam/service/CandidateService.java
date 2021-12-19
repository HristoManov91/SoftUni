package com.example.bootcampexam.service;

import com.example.bootcampexam.model.view.CandidateViewModel;

public interface CandidateService {

    CandidateViewModel getCandidateViewById(Long id);

    void deleteById(Long id);
}
