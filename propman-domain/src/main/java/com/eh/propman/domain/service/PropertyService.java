package com.eh.propman.domain.service;

import com.eh.propman.domain.data.AmenityData;
import com.eh.propman.domain.data.PropertyData;
import com.eh.propman.domain.data.PropertySearchData;
import com.eh.propman.domain.data.PropertyTypeData;
import com.eh.propman.commons.exceptions.PropertyManagementException;

import java.util.List;
import java.util.Map;

public interface PropertyService {

    PropertyData saveOrUpdate(PropertyData propertyData) throws PropertyManagementException;

    PropertyData getById(Long id) throws PropertyManagementException;

    List<PropertyData> getAll() throws PropertyManagementException;

    List<PropertyData> getAllById(List<Long> ids) throws PropertyManagementException;

    List<PropertyData> search(final PropertySearchData propertySearchData) throws PropertyManagementException;

    Long deleteById(Long id) throws PropertyManagementException;

    PropertyData update(PropertyData propertyData) throws PropertyManagementException;

    Map<PropertyTypeData, List<PropertyData>> getPropertiesByType(List<PropertyTypeData> propertyTypeDataList);

    Map<AmenityData, List<PropertyData>> getPropertiesByAmenity(List<AmenityData> amenityDataList);

}
