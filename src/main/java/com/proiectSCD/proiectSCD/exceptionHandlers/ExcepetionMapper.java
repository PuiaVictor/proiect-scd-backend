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
    public ResponseEntity handleUserExceptions(final UserException exception){

        final Map<String, Object> userExceptionsHandler = new HashMap<>();
        userExceptionsHandler.put("status", exception.getStatus());
        userExceptionsHandler.put("message", exception.getMessage());

        return new ResponseEntity(
                userExceptionsHandler,
                HttpStatus.valueOf(exception.getStatus())
        );
    }

    @ExceptionHandler(value = {LocationException.class})
    public ResponseEntity handleLocationExceptions(final LocationException exception){

        final Map<String, Object> locationExceptionsHandler = new HashMap<>();
        locationExceptionsHandler.put("status", exception.getStatus());
        locationExceptionsHandler.put("message", exception.getMessage());

        return new ResponseEntity(
                locationExceptionsHandler,
                HttpStatus.valueOf(exception.getStatus())
        );
    }
}
