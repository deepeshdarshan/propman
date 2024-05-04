package com.eh.propman.app.property.modal;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PropertyCreateRequest {

    private String name;

    private String url;

    private String description;

    private Double price;

    private Integer rating;

    private Integer preference;

    private Long type;

    private List<Long> amenities;
}
