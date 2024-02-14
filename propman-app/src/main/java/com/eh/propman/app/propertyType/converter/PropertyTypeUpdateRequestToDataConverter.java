package com.eh.propman.app.propertyType.converter;

import com.eh.propman.app.propertyType.modal.PropertyTypeUpdateRequest;
import com.eh.propman.domain.data.PropertyTypeData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class PropertyTypeUpdateRequestToDataConverter implements Converter<PropertyTypeUpdateRequest, PropertyTypeData> {

    @Override
    public PropertyTypeData convert(PropertyTypeUpdateRequest source) {
        return PropertyTypeData.builder()
                .withId(source.getId())
                .withName(source.getName())
                .build();
    }
}
