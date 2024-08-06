package com.pedromelobitencourt.job_vacancy_management.exceptions;

import java.util.ArrayList;

import org.apache.logging.log4j.message.Message;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource message) {
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ArrayList<ErrorMessageDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ArrayList<ErrorMessageDTO> dto = new ArrayList<>();

        e.getBindingResult().getAllErrors().forEach(err -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());    
            String field = null;
            if(err instanceof FieldError) field = ((FieldError) err).getField();

            ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(message, field);
            dto.add(errorMessageDTO);
        });

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
