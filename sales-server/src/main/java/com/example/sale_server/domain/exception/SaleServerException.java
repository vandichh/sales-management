package com.example.sale_server.domain.exception;

import com.example.common.domain.MessageCode;

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

    public abstract MessageCode getMessageCode();
}
