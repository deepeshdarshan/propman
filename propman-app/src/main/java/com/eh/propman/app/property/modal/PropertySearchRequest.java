package com.eh.propman.app.property.modal;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PropertySearchRequest {

    private List<String> name;

    private Double price;

    private List<Integer> rating;

    private List<Integer> preference;

    private List<Long> type;

    private List<Long> amenity;
}
