package com.eh.propman.domain.data;

import com.eh.propman.infra.entity.PropertyType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class PropertyData {

    private Long id;

    private String name;

    private String url;

    private String description;

    private Double price;

    private Integer rating;

    private Integer preference;

    private Long typeId;
}
