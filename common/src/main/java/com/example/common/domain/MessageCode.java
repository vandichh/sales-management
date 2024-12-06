package com.example.common.domain;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MessageCode {

    UNEXPECTED_SYSTEM_ERROR(
            HttpStatus.INTERNAL_SERVER_ERROR, "ER0001", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()
    ),
    BAD_REQUEST("ER0002", HttpStatus.BAD_REQUEST.getReasonPhrase()),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "ER0003", null);

    private final HttpStatus httpStatus;

    private final String code;

    private final String message;

    MessageCode(String code, String message) {
        this(HttpStatus.BAD_REQUEST, code, message);
    }

    MessageCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public boolean isSystemError() {
        return this.httpStatus.is5xxServerError();
    }

    @Override
    public String toString() {
        return this.name() + "[" + this.code + "]";
    }
}
