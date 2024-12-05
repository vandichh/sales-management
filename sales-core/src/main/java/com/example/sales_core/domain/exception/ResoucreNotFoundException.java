package com.example.sales_core.domain.exception;

public class ResoucreNotFoundException extends SaleCoreException{
    public ResoucreNotFoundException(String message) {
        super(message);
    }

    public ResoucreNotFoundException(Throwable cause) {
        super(cause);
    }

    public ResoucreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public int getCode() {
        return 0;
    }
}
