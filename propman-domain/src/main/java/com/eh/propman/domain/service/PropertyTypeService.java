package com.eh.propman.domain.service;

import com.eh.propman.domain.data.PropertyTypeData;
import com.eh.propman.commons.exceptions.PropertyManagementException;

import java.util.List;

public interface PropertyTypeService {

    public PropertyTypeData saveOrUpdate(PropertyTypeData propertyTypeData) throws PropertyManagementException;

    public PropertyTypeData getById(Long id) throws PropertyManagementException;

    public List<PropertyTypeData> getAll() throws PropertyManagementException;

    public Long deleteById(Long id) throws PropertyManagementException;

    public PropertyTypeData update(PropertyTypeData propertyTypeData) throws PropertyManagementException;
}
