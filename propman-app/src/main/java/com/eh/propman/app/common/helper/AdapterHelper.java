package com.eh.propman.app.common.helper;

import com.eh.propman.commons.error.ErrorTypes;
import com.eh.propman.commons.exceptions.InvalidPropertyException;
import com.eh.propman.commons.exceptions.InvalidPropertyTypeException;

import java.util.Optional;
import java.util.function.Supplier;

public class AdapterHelper {

    protected void validateProperty(Long id) {
        Optional.ofNullable(id).filter(pid -> pid > 0).orElseThrow(invalidPropertyException(id));
    }

    protected void validatePropertyType(Long id) {
        Optional.ofNullable(id).filter(pid -> pid > 0).orElseThrow(invalidPropertyTypeException(id));
    }

    private Supplier<InvalidPropertyException> invalidPropertyException(final Long id) {
        return ()-> new InvalidPropertyException(ErrorTypes.INVALID_PROPERTY, "{0} is not a valid property id", Long.toString(id));
    }

    private Supplier<InvalidPropertyTypeException> invalidPropertyTypeException(final Long id) {
        return ()-> new InvalidPropertyTypeException(ErrorTypes.INVALID_PROPERTY_TYPE, "{0} is not a valid property type id", Long.toString(id));
    }
}
