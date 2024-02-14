package com.eh.propman.app.propertyType.converter;

import com.eh.propman.app.propertyType.modal.PropertyTypeCreateRequest;
import com.eh.propman.domain.data.PropertyTypeData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class PropertyTypeCreateRequestToDataConverter implements Converter<PropertyTypeCreateRequest, PropertyTypeData> {

    @Override
    public PropertyTypeData convert(PropertyTypeCreateRequest source) {
        return PropertyTypeData.builder()
                .withName(source.getName())
                .build();
    }
}
