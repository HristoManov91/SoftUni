package com.example.bootcampexam.web;

import com.example.bootcampexam.model.view.SkillViewModel;
import com.example.bootcampexam.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillViewModel> getSkillById(@PathVariable Long id){

        SkillViewModel skill = skillService.getSkillViewById(id);

        return ResponseEntity.ok(skill);
    }

    @GetMapping("/active")
    public ResponseEntity<List<SkillViewModel>> getActiveSkills(){
        //ToDo implement
        return ResponseEntity.ok(null);
    }
}
