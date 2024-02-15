package com.eh.propman.app.propertyType.adapter;

import com.eh.propman.app.property.modal.PropertyResponse;
import com.eh.propman.app.shared.helper.AdapterHelper;
import com.eh.propman.app.shared.modal.Result;
import com.eh.propman.app.propertyType.modal.PropertyTypeCreateRequest;
import com.eh.propman.app.propertyType.modal.PropertyTypeResponse;
import com.eh.propman.app.propertyType.modal.PropertyTypeUpdateRequest;
import com.eh.propman.commons.exceptions.PropertyManagementBusinessException;
import com.eh.propman.domain.data.PropertyData;
import com.eh.propman.domain.data.PropertyTypeData;
import com.eh.propman.domain.service.PropertyService;
import com.eh.propman.domain.service.PropertyTypeService;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.eh.propman.app.shared.modal.Status.SUCCESS;

@Service
public class PropertyTypeAdapter extends AdapterHelper {

    private final PropertyTypeService propertyTypeService;

    private final PropertyService propertyService;

    private final ConversionService conversionService;

    public PropertyTypeAdapter(PropertyTypeService propertyTypeService, PropertyService propertyService, ConversionService conversionService) {
        this.propertyTypeService = propertyTypeService;
        this.propertyService = propertyService;
        this.conversionService = conversionService;
    }

    public PropertyTypeResponse save(final PropertyTypeCreateRequest property) {
        PropertyTypeData request = conversionService.convert(property, PropertyTypeData.class);
        return Try.of(() -> propertyTypeService.saveOrUpdate(request))
                .map(response -> conversionService.convert(response, PropertyTypeResponse.class))
                .onFailure(PropertyManagementBusinessException::new)
                .get();
    }

    public PropertyTypeResponse getById(final Long id) {
        validatePropertyType(id);
        PropertyTypeData propertyTypeData = propertyTypeService.getById(id);
        return conversionService.convert(propertyTypeData, PropertyTypeResponse.class);
    }

    public List<PropertyTypeResponse> getAll() {
        List<PropertyTypeData> propertyTypeDataList = propertyTypeService.getAll();
        return propertyTypeDataList.stream()
                .map(prop -> conversionService.convert(prop, PropertyTypeResponse.class))
                .toList();
    }

    public Result deleteById(final Long id) {
        validatePropertyType(id);
        Long propertyTypeId = propertyTypeService.deleteById(id);
        return Result.builder().withId(propertyTypeId).withStatus(SUCCESS).build();
    }

    public PropertyTypeResponse update(final PropertyTypeUpdateRequest property) {
        PropertyTypeData request = conversionService.convert(property, PropertyTypeData.class);
        return Try.of(() -> propertyTypeService.update(request))
                .map(response -> conversionService.convert(response, PropertyTypeResponse.class))
                .onFailure(PropertyManagementBusinessException::new)
                .get();
    }

    public Map<PropertyTypeResponse, List<PropertyResponse>> getProperties(List<PropertyTypeResponse> propertyTypes) {
        List<PropertyTypeData> propertyTypeDataList = propertyTypes.stream()
                .map(p -> PropertyTypeData.builder().withId(p.getId()).withName(p.getName()).build())
                .toList();
        Map<PropertyTypeData, List<PropertyData>> propertiesByType = propertyService.getPropertiesByType(propertyTypeDataList);
        return propertiesByType.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> conversionService.convert(e.getKey(), PropertyTypeResponse.class),
                        e -> e.getValue().stream()
                                .map(prop -> conversionService.convert(prop, PropertyResponse.class))
                                .toList()));
    }
}
