package com.eh.propman.domain.converter;

import com.eh.propman.domain.data.PropertyTypeData;
import com.eh.propman.infra.entity.PropertyType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class PropertyTypeEntityToDataConverter implements Converter<PropertyType, PropertyTypeData> {

    @Override
    public PropertyTypeData convert(PropertyType source) {
        return PropertyTypeData.builder()
                .withId(source.getId())
                .withName(source.getName())
                .build();
    }
}
