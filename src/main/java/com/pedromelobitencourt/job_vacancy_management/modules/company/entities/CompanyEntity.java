package com.pedromelobitencourt.job_vacancy_management.modules.company.entities;

import java.sql.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "company")
@Data
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @NotBlank
    @Pattern(regexp = "^[^\\s]+$", message = "O campo [username] não deve conter espaços")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;
    private String website;
    private String description;
    private String password;

    @CreationTimestamp
    private Date createdAt;
}
