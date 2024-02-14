package com.eh.propman.app.property.usecase;

import com.eh.propman.app.shared.modal.Result;
import com.eh.propman.app.property.adapter.PropertyAdapter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class DeletePropertyUseCase {

    private final PropertyAdapter propertyAdapter;

    public DeletePropertyUseCase(PropertyAdapter propertyAdapter) {
        this.propertyAdapter = propertyAdapter;
    }

    @QueryMapping
    public Result deletePropertyById(@Argument Long id) {
        return propertyAdapter.deleteById(id);
    }
}
