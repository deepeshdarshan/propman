package com.eh.propman.app.property.modal;

import com.eh.propman.app.propertyType.modal.PropertyTypeResponse;
import com.eh.propman.infra.entity.PropertyType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class PropertyResponse {

    private Long id;

    private String name;

    private String url;

    private String description;

    private Double price;

    private Integer rating;

    private Integer preference;

    private Long typeId;
}
