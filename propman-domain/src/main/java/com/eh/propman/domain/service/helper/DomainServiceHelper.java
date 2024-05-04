package com.eh.propman.domain.service.helper;

import com.eh.propman.commons.error.ErrorTypes;
import com.eh.propman.commons.exceptions.NoAmenityFoundException;
import com.eh.propman.commons.exceptions.NoPropertyFoundException;
import com.eh.propman.commons.exceptions.NoPropertyTypeFoundException;

import java.util.function.Supplier;

public class DomainServiceHelper {

    protected static Supplier<NoPropertyTypeFoundException> noPropertyTypeFoundException(final Long id) {
        return () -> new NoPropertyTypeFoundException(ErrorTypes.PROPERTY_TYPE_NOT_FOUND, "Property type not found for id: {0}", Long.toString(id));
    }

    protected static Supplier<NoPropertyFoundException> noPropertyFoundException(final Long id) {
        return () -> new NoPropertyFoundException(ErrorTypes.PROPERTY_NOT_FOUND, "Property not found for id: {0}", Long.toString(id));
    }

    protected static NoAmenityFoundException noAmenityFoundException(final Long id) {
        return new NoAmenityFoundException(ErrorTypes.AMENITY_NOT_FOUND, "Amenity not found for id: {0}", Long.toString(id));
    }
}
