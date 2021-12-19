package com.example.bootcampexam.service;

import com.example.bootcampexam.model.view.JobViewModel;

import java.util.List;

public interface JobService {

    List<JobViewModel> findAllJobsViewWithSkill(String skillName);
}
