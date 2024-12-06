package com.example.sales_core.presentation.rest;

import com.example.common.domain.MessageCode;
import com.example.sales_core.domain.exception.SaleCoreException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SaleCoreException.class)
    public ResponseEntity<Object> handleApplicationFailure(SaleCoreException exception) {
        MessageCode messageCode = exception.getMessageCode();
        HttpStatus httpStatus = messageCode.getHttpStatus();

        if (httpStatus.is5xxServerError()) {
            log.error("System error occurred.", exception);
        } else {
            log.warn(exception.getMessage());
        }

        return this.createResponse(httpStatus, messageCode, exception);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleSystemError(Exception exception) {
        log.error("System error occurred.", exception);
        return this.createResponse(HttpStatus.INTERNAL_SERVER_ERROR, MessageCode.UNEXPECTED_SYSTEM_ERROR, exception);
    }

    private ResponseEntity<Object> createResponse(HttpStatusCode httpStatusCode, MessageCode messageCode, Exception exception) {
        String message = messageCode.getMessage();
        if (message == null) {
            message = exception.getMessage();
        }

        return new ResponseEntity<>(new ErrorResponse(messageCode.getCode(), message), httpStatusCode);
    }

    private ResponseEntity<Object> createResponse(HttpStatus httpStatus, MessageCode messageCode, String errorMessage) {
        return new ResponseEntity<>(new ErrorResponse(messageCode.getCode(), errorMessage), httpStatus);
    }

    public static class ErrorResponse {

        public final String errorCode;

        public final String message;

        ErrorResponse(String errorCode, String message) {
            this.errorCode = errorCode;
            this.message = message;
        }
    }
}
