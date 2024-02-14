package com.eh.propman.commons.exceptions;

import java.text.MessageFormat;

public class NoPropertyFoundException extends PropertyManagementException {

    public NoPropertyFoundException(ErrorTypes errorTypes, String message, Object... arguments) {
        super(MessageFormat.format(message, arguments), new Throwable(errorTypes.name()));
    }
}
