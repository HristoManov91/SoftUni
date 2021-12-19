package com.example.bootcampexam.web;

import com.example.bootcampexam.model.view.JobViewModel;
import com.example.bootcampexam.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("{skillName}")
    public ResponseEntity<List<JobViewModel>> getAllJobsWithSkill(@PathVariable String skillName){

        List<JobViewModel> allJobsViewWithSkill = jobService.findAllJobsViewWithSkill(skillName);

        return ResponseEntity.ok(allJobsViewWithSkill);
    }
}
