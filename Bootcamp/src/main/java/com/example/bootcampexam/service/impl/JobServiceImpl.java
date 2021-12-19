package com.example.bootcampexam.service.impl;

import com.example.bootcampexam.model.entity.JobEntity;
import com.example.bootcampexam.model.view.JobViewModel;
import com.example.bootcampexam.model.view.SkillViewModel;
import com.example.bootcampexam.repository.JobRepository;
import com.example.bootcampexam.service.JobService;
import com.example.bootcampexam.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    public JobServiceImpl(JobRepository jobRepository, ModelMapper modelMapper) {
        this.jobRepository = jobRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<JobViewModel> findAllJobsViewWithSkill(String skillName) {
        List<JobEntity> jobEntities = jobRepository.findAllJobsContainsSkill(skillName)
                .orElseThrow(() -> new ObjectNotFoundException("We don't have job with this skill!"));

        return mapToJobViewModel(jobEntities);
    }

    private List<JobViewModel> mapToJobViewModel(List<JobEntity> jobEntities) {
        return jobEntities.stream().map(jobEntity -> {
            JobViewModel job = modelMapper.map(jobEntity, JobViewModel.class);

            job.setSkills(jobEntity
                    .getSkills()
                    .stream()
                    .map(skillEntity -> modelMapper.map(skillEntity, SkillViewModel.class))
                    .collect(Collectors.toUnmodifiableList()));

            return job;
        }).collect(Collectors.toUnmodifiableList());
    }
}
