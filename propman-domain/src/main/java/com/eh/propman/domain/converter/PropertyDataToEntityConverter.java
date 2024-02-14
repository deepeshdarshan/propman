package com.eh.propman.domain.converter;


import com.eh.propman.domain.data.PropertyData;
import com.eh.propman.infra.entity.Property;
import com.eh.propman.infra.entity.PropertyType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class PropertyDataToEntityConverter implements Converter<PropertyData, Property> {

    @Override
    public Property convert(PropertyData source) {
        return Property.builder()
                .withId(source.getId())
                .withName(source.getName())
                .withUrl(source.getUrl())
                .withPreference(source.getPreference())
                .withDescription(source.getDescription())
                .withRating(source.getRating())
                .withPrice(source.getPrice())
                .withType(PropertyType.builder()
                        .withId(source.getTypeId())
                        .build())
                .build();
    }
}
