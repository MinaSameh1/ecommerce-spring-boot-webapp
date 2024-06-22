package com.ecommerce.webapp.common.exceptions;

import com.ecommerce.webapp.common.exceptions.HttpException.HttpException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(HttpException.class)
    public ResponseEntity<CustomExceptionWithDetails> handleHttpException(HttpException ex) {
        CustomExceptionWithDetails exception = new CustomExceptionWithDetails(ex.getMessage(), ex.getDetails(),
                ex.getTimestamp());
        // TODO: Log the exception
        return new ResponseEntity<>(exception, ex.getStatus());
    }

}
