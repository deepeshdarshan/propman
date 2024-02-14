package com.eh.propman.domain.converter;

import com.eh.propman.domain.data.PropertyTypeData;
import com.eh.propman.infra.entity.PropertyType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class PropertyTypeDataToEntityConverter implements Converter<PropertyTypeData, PropertyType> {

    @Override
    public PropertyType convert(PropertyTypeData source) {
        return PropertyType.builder()
                .withId(source.getId())
                .withName(source.getName())
                .build();
    }
}
