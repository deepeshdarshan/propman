package com.eh.propman.domain.service.impl;

import com.eh.propman.commons.utils.CommonsUtils;
import com.eh.propman.domain.data.AmenityData;
import com.eh.propman.domain.data.PropertyData;
import com.eh.propman.domain.data.PropertySearchData;
import com.eh.propman.domain.data.PropertyTypeData;
import com.eh.propman.commons.exceptions.PropertyManagementException;
import com.eh.propman.domain.service.PropertyService;
import com.eh.propman.domain.service.helper.DomainServiceHelper;
import com.eh.propman.infra.entity.Amenity;
import com.eh.propman.infra.entity.Property;
import com.eh.propman.infra.entity.PropertyType;
import com.eh.propman.infra.repository.AmenityRepository;
import com.eh.propman.infra.repository.PropertyRepository;
import com.eh.propman.infra.repository.PropertyTypeRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.eh.propman.infra.specification.PropertySearchSpecification.*;
import static java.util.stream.Collectors.toList;

@Service
public class PropertyDomainService extends DomainServiceHelper implements PropertyService {

    private final PropertyRepository repository;

    private final PropertyTypeRepository propertyTypeRepository;

    private final AmenityRepository amenityRepository;

    private final ConversionService conversionService;


    public PropertyDomainService(PropertyRepository repository,
                                 PropertyTypeRepository propertyTypeRepository,
                                 AmenityRepository amenityRepository,
                                 ConversionService conversionService) {
        this.repository = repository;
        this.propertyTypeRepository = propertyTypeRepository;
        this.amenityRepository = amenityRepository;
        this.conversionService = conversionService;
    }

    @Override
    public PropertyData saveOrUpdate(final PropertyData propertyData) throws PropertyManagementException {
        Objects.requireNonNull(propertyData, "PropertyData cannot be null");
        PropertyType propertyType = propertyTypeRepository.findById(propertyData.getTypeId())
                .orElseThrow(noPropertyTypeFoundException(propertyData.getTypeId()));
        List<Amenity> amenities = amenityRepository.findAllById(propertyData.getAmenities());
        Property property = conversionService.convert(propertyData, Property.class);
        assert property != null;
        Property propertyResponse = repository.save(property.toBuilder().withType(propertyType).withAmenities(amenities).build());
        return conversionService.convert(propertyResponse, PropertyData.class);
    }

    @Override
    public PropertyData getById(Long id) throws PropertyManagementException {
        Objects.requireNonNull(id, "Property id cannot be null");
        Optional<Property> optionalProperty = repository.findById(id);
        return optionalProperty.map(property -> conversionService.convert(property, PropertyData.class))
                .orElseThrow(noPropertyFoundException(id));
    }

    @Override
    public List<PropertyData> getAll() throws PropertyManagementException {
        List<Property> properties = repository.findAll();
        return getPropertyData(properties);
    }

    @Override
    public List<PropertyData> getAllById(List<Long> ids) throws PropertyManagementException {
        Objects.requireNonNull(ids, "Property ids cannot be null");
        List<Property> properties = repository.findAllById(ids);
        return getPropertyData(properties);
    }

    @Override
    public List<PropertyData> search(final PropertySearchData propertySearchData) throws PropertyManagementException {
        Objects.requireNonNull(propertySearchData, "PropertySearchData cannot be null");
        List<Long> typeIds = List.copyOf(propertySearchData.getTypes());
        List<Long> amenityIds = List.copyOf(propertySearchData.getAmenities());
        Specification<Property> searchSpecifications = byName(propertySearchData.getNames())
                .and(byPrice(propertySearchData.getPrice()))
                .and(byPreference(propertySearchData.getPreferences()))
                .and(byRating(propertySearchData.getRatings()))
                .and(byType(typeIds))
                .and(byAmenity(amenityIds));
        List<Property> properties = repository.findAll(Specification.where(searchSpecifications));
        return getPropertyData(properties);
    }

    @Override
    public Long deleteById(Long id) throws PropertyManagementException {
        Objects.requireNonNull(id, "Property id cannot be null");
        PropertyData propertyData = getById(id);
        repository.deleteById(propertyData.getId());
        return id;
    }

    @Override
    public PropertyData update(PropertyData requestData) throws PropertyManagementException {
        Objects.requireNonNull(requestData.getId(), "PropertyData cannot be null");
        PropertyData propertyData = getById(requestData.getId());
        CommonsUtils.copyProperties(requestData, propertyData);
        return saveOrUpdate(propertyData);
    }

    @Override
    public Map<PropertyTypeData, List<PropertyData>> getPropertiesByType(List<PropertyTypeData> propertyTypeDataList) {
        Objects.requireNonNull(propertyTypeDataList, "PropertyTypeData list cannot be null");
        Map<Long, PropertyTypeData> propertyTypeMap = propertyTypeDataList.stream()
                .collect(Collectors.toMap(PropertyTypeData::getId, Function.identity()));
        List<Property> properties = repository.findAll(Specification.where(byType(propertyTypeMap.keySet())));
        Map<Long, List<Property>> propertyMap = properties.stream()
                .collect(Collectors.groupingBy(property -> property.getType().getId()));
        return propertyMap.entrySet().stream()
                .collect(Collectors.toMap(e -> propertyTypeMap.get(e.getKey()), e -> getPropertyData(e.getValue())));
    }

    @Override
    public Map<AmenityData, List<PropertyData>> getPropertiesByAmenity(List<AmenityData> amenityDataList) {
        return null;
    }

    private List<PropertyData> getPropertyData(List<Property> properties) {
        return properties.stream()
                .filter(Objects::nonNull)
                .map(prop -> conversionService.convert(prop, PropertyData.class))
                .toList();
    }
}
