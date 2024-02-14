package com.eh.propman.commons.exceptions;

import java.text.MessageFormat;

public class InvalidPropertyTypeException extends PropertyManagementException {

    public InvalidPropertyTypeException(ErrorTypes errorTypes, String message, Object... arguments) {
        super(MessageFormat.format(message, arguments), new Throwable(errorTypes.name()));
    }
}
