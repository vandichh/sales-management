package com.example.sale_server.presentation.rest;

import com.example.common.domain.MessageCode;
import com.example.sale_server.domain.exception.SaleServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SaleServerException.class)
    public ResponseEntity<Object> handleApplicationFailure(SaleServerException exception) {
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

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handleClientError(HttpClientErrorException exception) {
        log.error("HttpClientErrorException error occurred.", exception);
        return this.createResponse(HttpStatus.BAD_REQUEST, MessageCode.BAD_REQUEST, exception.getMessage());
    }

    private ResponseEntity<Object> createResponse(HttpStatusCode httpStatusCode, MessageCode messageCode, Exception exception) {
        String message = messageCode.getMessage();
        if (message == null) {
            message = exception.getMessage();
        }

        return new ResponseEntity<>(new ErrorResponse(messageCode.getCode(), message), httpStatusCode);
    }

    private ResponseEntity<Object> createResponse(HttpStatusCode httpStatusCode, MessageCode messageCode, String errorMessage) {
        return new ResponseEntity<>(new ErrorResponse(messageCode.getCode(), errorMessage), httpStatusCode);
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
