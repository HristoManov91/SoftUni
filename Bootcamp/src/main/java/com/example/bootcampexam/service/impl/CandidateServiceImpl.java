package com.example.bootcampexam.service.impl;

import com.example.bootcampexam.model.entity.CandidateEntity;
import com.example.bootcampexam.model.view.CandidateViewModel;
import com.example.bootcampexam.model.view.RecruiterViewModel;
import com.example.bootcampexam.model.view.SkillViewModel;
import com.example.bootcampexam.repository.CandidateRepository;
import com.example.bootcampexam.service.CandidateService;
import com.example.bootcampexam.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final ModelMapper modelMapper;

    public CandidateServiceImpl(CandidateRepository candidateRepository, ModelMapper modelMapper) {
        this.candidateRepository = candidateRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CandidateViewModel getCandidateViewById(Long id) {

        CandidateEntity candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Candidate with this id " + id + " not found"));

        CandidateViewModel result = modelMapper.map(candidate, CandidateViewModel.class);
        result.setRecruiter(modelMapper.map(candidate.getRecruiterEntity(), RecruiterViewModel.class));
        result.setSkills(
                candidate.getSkills()
                        .stream()
                        .map(s -> modelMapper.map(s, SkillViewModel.class))
                        .collect(Collectors.toUnmodifiableList()));

        return result;
    }

    @Override
    public void deleteById(Long id) {
        candidateRepository.deleteById(id);
    }
}
