package com.eh.propman.app.property.converter;

import com.eh.propman.app.property.modal.PropertySearchRequest;
import com.eh.propman.domain.data.PropertySearchData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.List.copyOf;
import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class PropertySearchRequestToDataConverter implements Converter<PropertySearchRequest, PropertySearchData> {

    @Override
    public PropertySearchData convert(PropertySearchRequest source) {
        return PropertySearchData.builder()
                .withTypes(getCopyOrEmptyList(source.getType()))
                .withNames(getCopyOrEmptyList(source.getName()))
                .withPrice(source.getPrice())
                .withRatings(getCopyOrEmptyList(source.getRating()))
                .withPreferences(getCopyOrEmptyList(source.getPreference()))
                .withAmenities(getCopyOrEmptyList(source.getAmenity()))
                .build();
    }

    private <T> List<T> getCopyOrEmptyList(List<T> sourceList) {
        return isEmpty(sourceList) ? emptyList() : copyOf(sourceList);
    }
}
