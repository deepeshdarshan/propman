package com.eh.propman.app.propertyType.converter;

import com.eh.propman.app.propertyType.modal.PropertyTypeResponse;
import com.eh.propman.domain.data.PropertyTypeData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyTypeDataToResponseConverter implements Converter<PropertyTypeData, PropertyTypeResponse> {

    @Override
    public PropertyTypeResponse convert(PropertyTypeData source) {
        return PropertyTypeResponse.builder()
                .withId(source.getId())
                .withName(source.getName())
                .build();
    }
}
