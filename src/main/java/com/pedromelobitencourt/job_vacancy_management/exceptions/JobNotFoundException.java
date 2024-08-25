package com.pedromelobitencourt.job_vacancy_management.exceptions;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException() {
        super("Job not Found!");
    }
}
