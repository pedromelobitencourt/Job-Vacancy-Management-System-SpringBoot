package com.pedromelobitencourt.job_vacancy_management.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedromelobitencourt.job_vacancy_management.modules.candidate.CandidateEntity;
import com.pedromelobitencourt.job_vacancy_management.modules.candidate.useCases.CreateCandidateUseCase;
import com.pedromelobitencourt.job_vacancy_management.modules.candidate.useCases.ProfileCandidateUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private ProfileCandidateUseCase profileCandidateUseCase;

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> get(HttpServletRequest request) {
        var candidateId = request.getAttribute("candidate_id");
        try {
            var profile = this.profileCandidateUseCase.execute(UUID.fromString(candidateId.toString()));
            return ResponseEntity.ok().body(profile);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
