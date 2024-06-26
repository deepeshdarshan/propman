package com.eh.propman.app.property.adapter;

import com.eh.propman.app.common.helper.AdapterHelper;
import com.eh.propman.app.common.modal.Result;
import com.eh.propman.app.common.modal.Status;
import com.eh.propman.app.property.modal.PropertyCreateRequest;
import com.eh.propman.app.property.modal.PropertyResponse;
import com.eh.propman.app.property.modal.PropertySearchRequest;
import com.eh.propman.app.property.modal.PropertyUpdateRequest;
import com.eh.propman.app.propertyType.modal.PropertyTypeResponse;
import com.eh.propman.commons.exceptions.PropertyManagementBusinessException;
import com.eh.propman.domain.data.PropertyData;
import com.eh.propman.domain.data.PropertySearchData;
import com.eh.propman.domain.data.PropertyTypeData;
import com.eh.propman.domain.service.PropertyService;
import com.eh.propman.domain.service.PropertyTypeService;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyAdapter extends AdapterHelper {

    private final PropertyService propertyService;

    private final PropertyTypeService propertyTypeService;

    private final ConversionService conversionService;

    public PropertyAdapter(PropertyService propertyService, PropertyTypeService propertyTypeService, ConversionService conversionService) {
        this.propertyService = propertyService;
        this.propertyTypeService = propertyTypeService;
        this.conversionService = conversionService;
    }

    public PropertyResponse save(final PropertyCreateRequest property) {
        PropertyData request = conversionService.convert(property, PropertyData.class);
        return Try.of(() -> propertyService.saveOrUpdate(request))
                .map(response -> conversionService.convert(response, PropertyResponse.class))
                .onFailure(PropertyManagementBusinessException::new)
                .get();
    }

    public PropertyResponse getById(final Long id) {
        validateProperty(id);
        PropertyData response = propertyService.getById(id);
        return conversionService.convert(response, PropertyResponse.class);
    }

    public List<PropertyResponse> getAll() {
        List<PropertyData> propertyDataList = propertyService.getAll();
        return toPropertyResponse(propertyDataList);
    }

    public Result deleteById(final Long id) {
        validateProperty(id);
        Long propertyId = propertyService.deleteById(id);
        return Result.builder().withId(propertyId).withStatus(Status.SUCCESS).build();
    }

    public PropertyResponse update(final PropertyUpdateRequest property) {
        PropertyData request = conversionService.convert(property, PropertyData.class);
        return Try.of(() -> propertyService.update(request))
                .map(response -> conversionService.convert(response, PropertyResponse.class))
                .onFailure(PropertyManagementBusinessException::new)
                .get();
    }

    public List<PropertyResponse> search(final PropertySearchRequest request) {
        PropertySearchData propertySearchData = conversionService.convert(request, PropertySearchData.class);
        List<PropertyData> propertyDataList = propertyService.search(propertySearchData);
        return toPropertyResponse(propertyDataList);
    }

    public PropertyTypeResponse getType(final Long id) {
        validatePropertyType(id);
        PropertyTypeData response = propertyTypeService.getById(id);
        return Optional.ofNullable(response)
                .map(data -> conversionService.convert(data, PropertyTypeResponse.class))
                .orElse(null);
    }

    private List<PropertyResponse> toPropertyResponse(List<PropertyData> propertyDataList) {
        return propertyDataList.stream()
                .map(prop -> conversionService.convert(prop, PropertyResponse.class))
                .collect(Collectors.toList());
    }
}
