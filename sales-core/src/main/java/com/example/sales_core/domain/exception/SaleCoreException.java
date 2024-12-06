package com.example.sales_core.domain.exception;

import com.example.common.domain.MessageCode;

public abstract class SaleCoreException extends RuntimeException {
    public SaleCoreException(String message) {
        super(message);
    }

    public SaleCoreException(Throwable cause) {
        super(cause);
    }

    public SaleCoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract MessageCode getMessageCode();
}
