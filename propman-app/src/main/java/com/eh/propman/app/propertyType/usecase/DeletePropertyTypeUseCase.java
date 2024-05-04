package com.eh.propman.app.propertyType.usecase;

import com.eh.propman.app.propertyType.adapter.PropertyTypeAdapter;
import com.eh.propman.app.common.modal.Result;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

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
