package com.eh.propman.app.property.converter;

import com.eh.propman.app.property.modal.PropertySearchRequest;
import com.eh.propman.domain.data.PropertySearchData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
public class PropertySearchRequestToDataConverter implements Converter<PropertySearchRequest, PropertySearchData> {

    @Override
    public PropertySearchData convert(PropertySearchRequest source) {
        return PropertySearchData.builder()
                .withTypes(CollectionUtils.isEmpty(source.getType()) ? Collections.emptyList() : List.copyOf(source.getType()))
                .withNames(CollectionUtils.isEmpty(source.getName()) ? Collections.emptyList() : List.copyOf(source.getName()))
                .withPrice(source.getPrice())
                .withRatings(CollectionUtils.isEmpty(source.getRating()) ? Collections.emptyList() : List.copyOf(source.getRating()))
                .withPreferences(CollectionUtils.isEmpty(source.getPreference()) ? Collections.emptyList() : List.copyOf(source.getPreference()))
                .build();
    }
}
