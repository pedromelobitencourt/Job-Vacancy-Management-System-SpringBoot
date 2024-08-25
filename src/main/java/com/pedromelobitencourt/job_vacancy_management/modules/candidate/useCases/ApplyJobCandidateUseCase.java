package com.pedromelobitencourt.job_vacancy_management.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedromelobitencourt.job_vacancy_management.exceptions.JobNotFoundException;
import com.pedromelobitencourt.job_vacancy_management.exceptions.UserNotFoundException;
import com.pedromelobitencourt.job_vacancy_management.modules.candidate.CandidateRepository;
import com.pedromelobitencourt.job_vacancy_management.modules.company.repositories.JobRepository;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;
    public void execute(UUID candidateId, UUID jobId) {
        // candidate exists
        this.candidateRepository.findById(candidateId)
            .orElseThrow(() -> { throw new UserNotFoundException(); });

        // job exists
        this.jobRepository.findById(jobId)
            .orElseThrow(() -> { throw new JobNotFoundException(); });
    }
}
