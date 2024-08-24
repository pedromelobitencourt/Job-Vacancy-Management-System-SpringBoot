package com.pedromelobitencourt.job_vacancy_management.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuário já existe");
    } 
    
}
