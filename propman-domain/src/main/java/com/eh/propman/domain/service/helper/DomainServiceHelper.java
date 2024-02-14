package com.eh.propman.domain.service.helper;

import com.eh.propman.commons.exceptions.ErrorTypes;
import com.eh.propman.commons.exceptions.NoPropertyFoundException;
import com.eh.propman.commons.exceptions.NoPropertyTypeFoundException;
import com.eh.propman.domain.data.PropertyData;
import com.eh.propman.infra.entity.Property;
import org.springframework.core.convert.ConversionService;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class DomainServiceHelper {

    private final ConversionService conversionService;

    public DomainServiceHelper(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    protected List<PropertyData> getPropertyData(List<Property> properties) {
        return properties.stream()
                .filter(Objects::nonNull)
                .map(prop -> conversionService.convert(prop, PropertyData.class))
                .toList();
    }

    protected static Supplier<NoPropertyTypeFoundException> noPropertyTypeFoundException(final Long id) {
        return () -> new NoPropertyTypeFoundException(ErrorTypes.PROPERTY_TYPE_NOT_FOUND, "Property type not found for id: {0}", Long.toString(id));
    }

    protected static Supplier<NoPropertyFoundException> noPropertyFoundException(final Long id) {
        return () -> new NoPropertyFoundException(ErrorTypes.PROPERTY_NOT_FOUND, "Property not found for id: {0}", Long.toString(id));
    }
}
