package com.trabalhoFinal.trabalhoFinal.execptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHanlder {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e){
        ErrorResponse error = ErrorResponse.builder()
                .code(e.toString())
                .message(e.getMessage())
                .timestamp(new Date().getTime())
                .build();

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}