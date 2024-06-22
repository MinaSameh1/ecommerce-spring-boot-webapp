package com.ecommerce.webapp.common.exceptions.HttpException;

import java.util.Date;

import com.ecommerce.webapp.common.exceptions.CustomExceptionWithDetails;

import org.springframework.http.HttpStatus;

/**
 * HttpException This class is used to create a custom exception with details.
 * 
 * @param message   - The message of the exception. Cannot be null.
 * @param status    - The status of the exception. Cannot be null.
 * @param details   - The details of the exception. Can be null.
 * @param timestamp - The timestamp of the exception. Can be null.
 */
public class HttpException extends CustomExceptionWithDetails {

    final private HttpStatus status;

    public HttpException(String message, HttpStatus status, Date timestamp, String details) {
        super(message, details, timestamp);
        this.status = status;
    }

    public HttpException(String message, HttpStatus status, String details) {
        super(message, details);
        this.status = status;
    }

    public HttpException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getStatusMessage() {
        return status.getReasonPhrase();
    }

    public int getStatusCode() {
        return status.value();
    }

    public String getDetails() {
        return super.getDetails();
    }

    public String getMessage() {
        return super.getMessage();
    }

    public Date getTimestamp() {
        return super.getTimestamp();
    }

    public void setMessage(String message) {
        super.setMessage(message);
    }

    public CustomExceptionWithDetails getExceptionWithDetails() {
        return new CustomExceptionWithDetails(super.getMessage(), super.getDetails(), super.getTimestamp());
    }
}
