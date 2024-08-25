package com.pedromelobitencourt.job_vacancy_management.modules.candidate.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateDTO {
    private String description;
    private String name;
    private String email;
    private String username;
    private UUID id;
}
