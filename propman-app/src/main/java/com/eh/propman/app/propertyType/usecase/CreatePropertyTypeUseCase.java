package com.eh.propman.app.propertyType.usecase;

import com.eh.propman.app.propertyType.modal.PropertyTypeCreateRequest;
import com.eh.propman.app.propertyType.modal.PropertyTypeResponse;
import com.eh.propman.app.propertyType.adapter.PropertyTypeAdapter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class CreatePropertyTypeUseCase {

    private final PropertyTypeAdapter propertyTypeAdapter;


    public CreatePropertyTypeUseCase(PropertyTypeAdapter propertyTypeAdapter) {
        this.propertyTypeAdapter = propertyTypeAdapter;
    }

    @MutationMapping
    public PropertyTypeResponse createPropertyType(@Argument PropertyTypeCreateRequest request) {
        return propertyTypeAdapter.save(request);
    }
}
