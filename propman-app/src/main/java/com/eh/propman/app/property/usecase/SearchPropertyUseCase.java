package com.eh.propman.app.property.usecase;

import com.eh.propman.app.property.modal.PropertyResponse;
import com.eh.propman.app.property.adapter.PropertyAdapter;
import com.eh.propman.app.property.modal.PropertySearchRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class SearchPropertyUseCase {

    private final PropertyAdapter propertyAdapter;

    public SearchPropertyUseCase(PropertyAdapter propertyAdapter) {
        this.propertyAdapter = propertyAdapter;
    }

    @QueryMapping
    public List<PropertyResponse> searchProperty(@Argument PropertySearchRequest request) {
        return propertyAdapter.search(request);
    }
}
