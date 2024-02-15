package com.eh.propman.commons.exceptions;

import java.text.MessageFormat;

public class PropertyManagementBusinessException extends RuntimeException {

    public PropertyManagementBusinessException(Throwable ex) {
        super(ex);
    }
}
