package com.example.bootcampexam.service;

import com.example.bootcampexam.model.entity.SkillEntity;
import com.example.bootcampexam.model.view.SkillViewModel;

public interface SkillService {

    SkillEntity createSkill(String skillName);

    SkillViewModel getSkillViewById(Long id);
}
