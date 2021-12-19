package com.example.bootcampexam.service.impl;

import com.example.bootcampexam.model.entity.SkillEntity;
import com.example.bootcampexam.model.view.SkillViewModel;
import com.example.bootcampexam.repository.SkillRepository;
import com.example.bootcampexam.service.SkillService;
import com.example.bootcampexam.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final ModelMapper modelMapper;

    public SkillServiceImpl(SkillRepository skillRepository, ModelMapper modelMapper) {
        this.skillRepository = skillRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SkillEntity createSkill(String skillName) {
        SkillEntity skill = skillRepository.findByName(skillName).orElse(null);

        if (skill == null){
            skill = new SkillEntity().setName(skillName);
        }

        return skill;
    }

    @Override
    public SkillViewModel getSkillViewById(Long id) {

        SkillEntity skill = skillRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Skill with this " + id + " not found"));

        return modelMapper.map(skill , SkillViewModel.class);
    }
}
