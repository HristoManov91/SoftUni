package com.example.bootcampexam.web;

import com.example.bootcampexam.model.binding.CreateCandidateBindingModel;
import com.example.bootcampexam.model.view.CandidateViewModel;
import com.example.bootcampexam.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCandidateBindingModel> create(@Valid @RequestBody CreateCandidateBindingModel bindingModel,
                                                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("bindingModel" , bindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.bindingModel", bindingResult);

            return null;
        }
        //ToDo
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateViewModel> getCandidateById(@PathVariable Long id){

        CandidateViewModel candidate = candidateService.getCandidateViewById(id);

        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CandidateViewModel> putCandidate(@PathVariable Long id){
        //ToDo implement
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CandidateViewModel> deleteCandidate(@PathVariable Long id){

        CandidateViewModel candidate = candidateService.getCandidateViewById(id);
        candidateService.deleteById(id);

        return ResponseEntity.ok(candidate);
    }

}
