package com.pedromelobitencourt.job_vacancy_management.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Data
public class CandidateEntity {
    private UUID id;
    private String name;

    @Pattern(regexp = "^[^\\s]+$", message = "O campo [username] não deve conter espaços")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    @Length(min = 5, max = 100)
    private String password;
    private String description;
    private String curriculum;
}
