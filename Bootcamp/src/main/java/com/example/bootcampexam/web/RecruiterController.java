package com.example.bootcampexam.web;

import com.example.bootcampexam.model.view.RecruiterViewModel;
import com.example.bootcampexam.service.RecruiterService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recruiters")
public class RecruiterController {

    private final RecruiterService recruiterService;
    private final ModelMapper modelMapper;

    public RecruiterController(RecruiterService recruiterService, ModelMapper modelMapper) {
        this.recruiterService = recruiterService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<RecruiterViewModel>> getActiveRecruiters(){
        //ToDo implement
        return null;
    }

    @GetMapping("{level}")
    public ResponseEntity<List<RecruiterViewModel>> getRecritersWithLevel(@PathVariable Integer level){
        //ToDo implement
        return null;
    }
}
