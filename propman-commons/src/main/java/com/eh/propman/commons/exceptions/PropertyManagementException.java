package com.eh.propman.commons.exceptions;

public class PropertyManagementException extends RuntimeException {

    public PropertyManagementException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertyManagementException(Throwable cause) {
        super(cause);
    }
}
