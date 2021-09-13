package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private final int errorCode;
    private final HttpStatus httpStatus;
    private final String message;
    private final ZonedDateTime timestamp;

    public ApiException(Integer errorCode,
                        HttpStatus httpStatus,
                        String message,
                        ZonedDateTime timestamp) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
