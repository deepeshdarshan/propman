package com.eh.propman.domain.service.impl;

import com.eh.propman.commons.utils.CommonsUtils;
import com.eh.propman.domain.data.PropertyTypeData;
import com.eh.propman.commons.exceptions.PropertyManagementException;
import com.eh.propman.domain.service.PropertyTypeService;
import com.eh.propman.domain.service.helper.DomainServiceHelper;
import com.eh.propman.infra.entity.PropertyType;
import com.eh.propman.infra.repository.PropertyTypeRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyTypeDomainService extends DomainServiceHelper implements PropertyTypeService {

    private final PropertyTypeRepository repository;

    private final ConversionService conversionService;

    public PropertyTypeDomainService(PropertyTypeRepository repository, ConversionService conversionService) {
        super(conversionService);
        this.repository = repository;
        this.conversionService = conversionService;
    }

    @Override
    public PropertyTypeData saveOrUpdate(PropertyTypeData requestData) throws PropertyManagementException {
        Objects.requireNonNull(requestData, "PropertyTypeData cannot be null");
        PropertyType propertyType = conversionService.convert(requestData, PropertyType.class);
        assert propertyType != null;
        PropertyType propertyTypeResponse = repository.save(propertyType);
        return conversionService.convert(propertyTypeResponse, PropertyTypeData.class);
    }

    @Override
    public PropertyTypeData getById(Long id) throws PropertyManagementException {
        Objects.requireNonNull(id, "PropertyTypeData id cannot be null");
        Optional<PropertyType> propertyType = repository.findById(id);
        return propertyType.map(entity -> conversionService.convert(entity, PropertyTypeData.class))
                .orElseThrow(noPropertyTypeFoundException(id));
    }

    @Override
    public List<PropertyTypeData> getAll() throws PropertyManagementException {
        List<PropertyType> propertyTypes = repository.findAll();
        return propertyTypes.stream()
                .filter(Objects::nonNull)
                .map(prop -> conversionService.convert(prop, PropertyTypeData.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long deleteById(Long id) throws PropertyManagementException {
        Objects.requireNonNull(id, "PropertyType id cannot be null");
        PropertyTypeData propertyTypeData = getById(id);
        repository.deleteById(propertyTypeData.getId());
        return id;
    }

    @Override
    public PropertyTypeData update(PropertyTypeData requestData) throws PropertyManagementException {
        Objects.requireNonNull(requestData.getId(), "PropertyTypeData id cannot be null");
        PropertyTypeData propertyTypeData = getById(requestData.getId());
        CommonsUtils.copyProperties(requestData, propertyTypeData);
        return saveOrUpdate(propertyTypeData);
    }
}
