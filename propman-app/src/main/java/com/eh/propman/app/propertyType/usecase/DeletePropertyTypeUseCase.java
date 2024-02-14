package com.eh.propman.app.propertyType.usecase;

import com.eh.propman.app.propertyType.adapter.PropertyTypeAdapter;
import com.eh.propman.app.shared.modal.Result;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class DeletePropertyTypeUseCase {

    private final PropertyTypeAdapter propertyTypeAdapter;

    public DeletePropertyTypeUseCase(PropertyTypeAdapter propertyTypeAdapter) {
        this.propertyTypeAdapter = propertyTypeAdapter;
    }

    @QueryMapping
    public Result deletePropertyTypeById(@Argument Long id) {
        return propertyTypeAdapter.deleteById(id);
    }
}
