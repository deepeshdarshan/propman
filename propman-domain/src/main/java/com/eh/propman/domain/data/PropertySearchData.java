package com.eh.propman.domain.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class PropertySearchData {

    private List<String> names;

    private Double price;

    private List<Integer> ratings;

    private List<Integer> preferences;

    private List<Long> types;

    private List<Long> amenities;
}
