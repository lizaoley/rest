package com.liza.rest.my_controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CreamRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CreamErrorResponse> handlerException(CreamNotFoundException e) {

        CreamErrorResponse er = new CreamErrorResponse();

        er.setStatus(HttpStatus.NOT_FOUND.value());
        er.setMessage(e.getMessage());
        er.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CreamErrorResponse> handlerException(Exception e) {

        CreamErrorResponse er = new CreamErrorResponse();

        er.setStatus(HttpStatus.BAD_REQUEST.value());
        er.setMessage("User enter invalid data. You must enter only INTEGER value.");
        er.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }
}
