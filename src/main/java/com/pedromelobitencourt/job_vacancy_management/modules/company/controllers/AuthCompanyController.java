package com.pedromelobitencourt.job_vacancy_management.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedromelobitencourt.job_vacancy_management.modules.company.dto.AuthCompanyDTO;
import com.pedromelobitencourt.job_vacancy_management.modules.company.useCases.AuthCompanyUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class AuthCompanyController {
    @Autowired
    private AuthCompanyUseCase authCompanyUseCase;
    
    @PostMapping("/auth")
    public ResponseEntity<Object> create(@Valid @RequestBody AuthCompanyDTO authCompanyDTO) {
        try {
            var result = authCompanyUseCase.execute(authCompanyDTO);
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
