package com.pedromelobitencourt.job_vacancy_management.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Usuário não existe");
    } 
    
}
