package com.eh.propman.commons.exceptions;

import com.eh.propman.commons.error.ErrorTypes;

import java.text.MessageFormat;

public class InvalidPropertyException extends PropertyManagementException {

    public InvalidPropertyException(ErrorTypes errorTypes, String message, Object... arguments) {
        super(MessageFormat.format(message, arguments), new Throwable(errorTypes.name()));
    }
}
