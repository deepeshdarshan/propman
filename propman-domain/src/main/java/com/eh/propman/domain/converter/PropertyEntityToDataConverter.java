package com.eh.propman.domain.converter;

import com.eh.propman.domain.data.PropertyData;
import com.eh.propman.infra.entity.Property;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class PropertyEntityToDataConverter implements Converter<Property, PropertyData> {

    @Override
    public PropertyData convert(Property source) {
        return PropertyData.builder()
                .withId(source.getId())
                .withName(source.getName())
                .withUrl(source.getUrl())
                .withPreference(source.getPreference())
                .withDescription(source.getDescription())
                .withRating(source.getRating())
                .withPrice(source.getPrice())
                .withTypeId(source.getType().getId())
                .build();
    }
}
