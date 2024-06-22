package com.ecommerce.webapp.common.exceptions;

import com.ecommerce.webapp.common.exceptions.HttpException.HttpException;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<CustomExceptionWithDetails> handleHttpException(HttpException ex) {
        CustomExceptionWithDetails exception = new CustomExceptionWithDetails(ex.getMessage(), ex.getDetails(),
                ex.getTimestamp());
        HttpStatus status = ex.getStatus();

        if (status.is4xxClientError()) {
            LOGGER.warn("Client error: " + exception.getMessage());
        } else if (status.is5xxServerError()) {
            LOGGER.error("Server error: " + exception.getMessage());
            // Just in case, this shouldn't happen as 2xx, 3xx are not exceptions and not handled here
        } else {
            LOGGER.info("Informational, success, or redirection status: " + exception.getMessage());
        }

        return new ResponseEntity<>(exception, status);
    }

}
