package com.example.bootcampexam.service.impl;

import com.example.bootcampexam.model.entity.RecruiterEntity;
import com.example.bootcampexam.repository.RecruiterRepository;
import com.example.bootcampexam.service.RecruiterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    private final RecruiterRepository recruiterRepository;

    public RecruiterServiceImpl(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }


    @Override
    public RecruiterEntity findByEmail(String email, String country, String lastName) {
        RecruiterEntity recruiter = recruiterRepository.findByEmail(email).orElse(null);

        if (recruiter == null) {
            recruiter = createRecruiter(email, country, lastName);
        } else {
            recruiter.setLevel(recruiter.getLevel() + 1);
        }

        return recruiter;
    }

    private RecruiterEntity createRecruiter(String email, String country, String lastName) {
        return new RecruiterEntity()
                .setEmail(email)
                .setCountry(country)
                .setLastName(lastName)
                .setLevel(1)
                .setCandidates(new ArrayList<>());
    }
}
