package com.pedromelobitencourt.job_vacancy_management.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pedromelobitencourt.job_vacancy_management.modules.candidate.CandidateRepository;
import com.pedromelobitencourt.job_vacancy_management.modules.candidate.dto.ProfileCandidateDTO;

@Service
public class ProfileCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateDTO execute(UUID candidateId) {
        var candidate = this.candidateRepository.findById(candidateId)
            .orElseThrow(() -> {
                throw new UsernameNotFoundException("User not found");
            });
        var candidateDTO = ProfileCandidateDTO.builder()
            .description(candidate.getDescription())
            .username(candidate.getUsername())
            .name(candidate.getName())
            .email(candidate.getEmail())
            .id(candidate.getId())
            .build();
        return candidateDTO;
    }
}
