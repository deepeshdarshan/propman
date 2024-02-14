package com.eh.propman.app.property.converter;

import com.eh.propman.app.property.modal.PropertyResponse;
import com.eh.propman.app.propertyType.modal.PropertyTypeResponse;
import com.eh.propman.domain.data.PropertyData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class PropertyDataToResponseConverter implements Converter<PropertyData, PropertyResponse> {

    @Override
    public PropertyResponse convert(PropertyData source) {
        return PropertyResponse.builder()
                .withId(source.getId())
                .withName(source.getName())
                .withUrl(source.getUrl())
                .withPreference(source.getPreference())
                .withDescription(source.getDescription())
                .withRating(source.getRating())
                .withPrice(source.getPrice())
                .withTypeId(source.getTypeId())
                .build();
    }
}
