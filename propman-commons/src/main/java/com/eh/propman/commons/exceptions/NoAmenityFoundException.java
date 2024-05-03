package com.eh.propman.commons.exceptions;

import java.text.MessageFormat;

public class NoAmenityFoundException extends PropertyManagementException {

    public NoAmenityFoundException(ErrorTypes errorTypes, String message, Object... arguments) {
        super(MessageFormat.format(message, arguments), new Throwable(errorTypes.name()));
    }
}
