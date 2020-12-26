package com.proiectSCD.proiectSCD.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExcepetionMapper extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserException.class})
    public ResponseEntity handleUserCreationExceptions(final UserException exception){

        final Map<String, Object> userCreationExceptionsHandler = new HashMap<>();
        userCreationExceptionsHandler.put("status", exception.getStatus());
        userCreationExceptionsHandler.put("message", exception.getMessage());

        return new ResponseEntity(
                userCreationExceptionsHandler,
                HttpStatus.valueOf(exception.getStatus())
        );
    }
}
