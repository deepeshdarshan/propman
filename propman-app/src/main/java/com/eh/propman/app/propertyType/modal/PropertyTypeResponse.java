package com.eh.propman.app.propertyType.modal;

import com.eh.propman.app.property.modal.PropertyResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(setterPrefix = "with")
public class PropertyTypeResponse {

    private Long id;

    private String name;
}
