package com.eh.propman.app.property.usecase;

import com.eh.propman.app.property.modal.PropertyResponse;
import com.eh.propman.app.property.modal.PropertyCreateRequest;
import com.eh.propman.app.property.adapter.PropertyAdapter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class CreatePropertyUseCase {

    private final PropertyAdapter propertyAdapter;


    public CreatePropertyUseCase(PropertyAdapter propertyAdapter) {
        this.propertyAdapter = propertyAdapter;
    }

    @MutationMapping
    public PropertyResponse createProperty(@Argument PropertyCreateRequest request) {
        return propertyAdapter.save(request);
    }
}
