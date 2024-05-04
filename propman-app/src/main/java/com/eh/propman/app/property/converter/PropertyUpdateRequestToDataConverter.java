package com.eh.propman.app.property.converter;

import com.eh.propman.app.property.modal.PropertyUpdateRequest;
import com.eh.propman.domain.data.PropertyData;
import com.eh.propman.domain.data.PropertyTypeData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import static java.util.List.copyOf;

@Service
public class PropertyUpdateRequestToDataConverter implements Converter<PropertyUpdateRequest, PropertyData> {

    @Override
    public PropertyData convert(PropertyUpdateRequest source) {
        return PropertyData.builder()
                .withId(source.getId())
                .withName(source.getName())
                .withUrl(source.getUrl())
                .withPreference(source.getPreference())
                .withDescription(source.getDescription())
                .withRating(source.getRating())
                .withPrice(source.getPrice())
                .withTypeId(source.getType())
                .withAmenities(copyOf(source.getAmenities()))
                .build();
    }
}
