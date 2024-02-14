package com.eh.propman.app.propertyType.usecase;

import com.eh.propman.app.property.modal.PropertyResponse;
import com.eh.propman.app.propertyType.modal.PropertyTypeResponse;
import com.eh.propman.app.propertyType.adapter.PropertyTypeAdapter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class GetPropertyTypeUseCase {

    private final PropertyTypeAdapter propertyTypeAdapter;

    public GetPropertyTypeUseCase(PropertyTypeAdapter propertyTypeAdapter) {
        this.propertyTypeAdapter = propertyTypeAdapter;
    }

    @QueryMapping
    public PropertyTypeResponse getPropertyTypeById(@Argument Long id) {
        return propertyTypeAdapter.getById(id);
    }

    @QueryMapping
    public List<PropertyTypeResponse> getAllPropertyTypes() {
        return propertyTypeAdapter.getAll();
    }

    @BatchMapping
    public Map<PropertyTypeResponse, List<PropertyResponse>> properties(final List<PropertyTypeResponse> propertyTypes) {
        return propertyTypeAdapter.getProperties(propertyTypes);
    }
}
