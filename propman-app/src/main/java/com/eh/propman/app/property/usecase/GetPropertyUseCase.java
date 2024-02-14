package com.eh.propman.app.property.usecase;

import com.eh.propman.app.property.modal.PropertyResponse;
import com.eh.propman.app.property.adapter.PropertyAdapter;
import com.eh.propman.app.propertyType.modal.PropertyTypeResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class GetPropertyUseCase {

    private final PropertyAdapter propertyAdapter;

    public GetPropertyUseCase(PropertyAdapter propertyAdapter) {
        this.propertyAdapter = propertyAdapter;
    }

    @QueryMapping
    public PropertyResponse getPropertyById(@Argument Long id) {
        return propertyAdapter.getById(id);
    }

    @QueryMapping
    public List<PropertyResponse> getAllProperties() {
        return propertyAdapter.getAll();
    }

    @SchemaMapping
    public PropertyTypeResponse type(PropertyResponse property) {
        return propertyAdapter.getType(property.getTypeId());
    }
}
