package com.pedromelobitencourt.job_vacancy_management.modules.candidate.useCases;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.UUID;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pedromelobitencourt.job_vacancy_management.exceptions.JobNotFoundException;
import com.pedromelobitencourt.job_vacancy_management.exceptions.UserNotFoundException;
import com.pedromelobitencourt.job_vacancy_management.modules.candidate.CandidateEntity;
import com.pedromelobitencourt.job_vacancy_management.modules.candidate.CandidateRepository;
import com.pedromelobitencourt.job_vacancy_management.modules.company.repositories.JobRepository;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {
    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Test
    @DisplayName("Should not be able to apply job with candidate not found")
    public void should_not_be_able_to_apply_job_with_candidate_not_found() {
        assertThrows(UserNotFoundException.class, () -> {
            this.applyJobCandidateUseCase.execute(null, null);
        });
    }

    @Test
    @DisplayName("Should not be able to apply job with job not found")
    public void should_not_be_able_to_apply_job_with_job_not_found() {
        var candidateId = UUID.randomUUID();
        var candidate = new CandidateEntity();
        candidate.setId(candidateId);
        
        when(this.candidateRepository.findById(candidateId))
            .thenReturn(Optional.of(candidate));

        assertThrows(JobNotFoundException.class, () -> {
            this.applyJobCandidateUseCase.execute(candidateId, null);
        });
    }
}
