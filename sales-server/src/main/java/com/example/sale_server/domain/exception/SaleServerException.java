package com.example.sale_server.domain.exception;

public abstract class SaleServerException extends RuntimeException {
    public SaleServerException(String message) {
        super(message);
    }

    public SaleServerException(Throwable cause) {
        super(cause);
    }

    public SaleServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getCode();
}
