package com.eh.propman.app.property.usecase;

import com.eh.propman.app.property.modal.PropertyResponse;
import com.eh.propman.app.property.modal.PropertyUpdateRequest;
import com.eh.propman.app.property.adapter.PropertyAdapter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class UpdatePropertyUseCase {

    private final PropertyAdapter propertyAdapter;

    public UpdatePropertyUseCase(PropertyAdapter propertyAdapter) {
        this.propertyAdapter = propertyAdapter;
    }

    @MutationMapping
    public PropertyResponse updateProperty(@Argument PropertyUpdateRequest request) {
        return propertyAdapter.update(request);
    }
}
