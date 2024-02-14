package com.eh.propman.app.propertyType.usecase;

import com.eh.propman.app.propertyType.modal.PropertyTypeResponse;
import com.eh.propman.app.propertyType.modal.PropertyTypeUpdateRequest;
import com.eh.propman.app.propertyType.adapter.PropertyTypeAdapter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class UpdatePropertyTypeUseCase {

    private final PropertyTypeAdapter propertyTypeAdapter;

    public UpdatePropertyTypeUseCase(PropertyTypeAdapter propertyTypeAdapter) {
        this.propertyTypeAdapter = propertyTypeAdapter;
    }

    @MutationMapping
    public PropertyTypeResponse updatePropertyType(@Argument PropertyTypeUpdateRequest request) {
        return propertyTypeAdapter.update(request);
    }
}
