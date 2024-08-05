package com.pedromelobitencourt.job_vacancy_management.exceptions;

import org.apache.logging.log4j.message.Message;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    private Message messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.getBindingResult().getAllErrors().forEach(err -> {
            //String message = messageSource.getFormattedMessage(err, LocaleContextHolder.getLocale());
        });
    }
}
