package com.ecommerce.webapp.common.exceptions;

import java.util.Date;

/**
 * CustomExceptionWithDetails This class is used to create a custom exception
 * with details.
 * 
 * @param message   - The message of the exception. Cannot be null.
 * @param details   - The details of the exception. Can be null.
 * @param timestamp - The timestamp of the exception. Can be null.
 */
public class CustomExceptionWithDetails extends Exception {
    private Date timestamp;
    private String message;
    private String details;

    public CustomExceptionWithDetails(String message, String details, final Date timestamp) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null.");
        }

        this.message = message;
        this.details = details;
        if (timestamp == null) {
            this.timestamp = new Date();
        } else {
            this.timestamp = timestamp;
        }
    }

    public CustomExceptionWithDetails(String message, String details) {
        this(message, details, null);
    }

    public CustomExceptionWithDetails(String message) {
        this(message, null, null);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
