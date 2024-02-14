package com.eh.propman.commons.exceptions;

import java.text.MessageFormat;

public class NoPropertyTypeFoundException extends PropertyManagementException {

    public NoPropertyTypeFoundException(ErrorTypes errorTypes, String message, Object... arguments) {
        super(MessageFormat.format(message, arguments), new Throwable(errorTypes.name()));
    }
}
