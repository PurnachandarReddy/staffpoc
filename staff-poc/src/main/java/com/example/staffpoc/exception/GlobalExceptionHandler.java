package com.example.staffpoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<String> handleNoDataFoundException(NoDataFoundException ex) {
        // Log the exception for debugging purposes
        ex.printStackTrace();

        // Customize the error message for no data found
        String errorMessage = ex.getMessage();

        
        // Return an error response with NOT_FOUND status code
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

}

