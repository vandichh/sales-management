package com.example.sale_server.domain.exception;

import com.example.common.domain.MessageCode;
import com.example.sale_server.domain.value.Either;


public class ResourceNotFoundException extends SaleServerException {
    private final MessageCode messageCode;

    public ResourceNotFoundException(String message, Throwable cause, MessageCode messageCode) {
        super(message, cause);
        this.messageCode = messageCode;
    }

    public static ResourceNotFoundException fromCoreApi(Either<?> result) {
        if (result.isSuccess()) {
            throw new IllegalStateException("This Either is success.");
        }

        String errorMessage = result.errorMessage();
        Exception cause = result.cause();

        return new ResourceNotFoundException(errorMessage, cause, MessageCode.RESOURCE_NOT_FOUND);
    }

    @Override
    public MessageCode getMessageCode() {
        return this.messageCode;
    }
}
