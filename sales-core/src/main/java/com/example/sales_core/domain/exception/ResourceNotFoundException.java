package com.example.sales_core.domain.exception;

import com.example.common.domain.MessageCode;

public class ResourceNotFoundException extends SaleCoreException {
    private final MessageCode messageCode;

    public ResourceNotFoundException(String message) {
        super(message);
        this.messageCode = MessageCode.RESOURCE_NOT_FOUND;
    }

    public ResourceNotFoundException(String message, Throwable cause, MessageCode messageCode) {
        super(message, cause);
        this.messageCode = messageCode;
    }

    @Override
    public MessageCode getMessageCode() {
        return this.messageCode;
    }
}
