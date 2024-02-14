package com.eh.propman.domain.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true, setterPrefix = "with")
public class PropertyTypeData {

    private Long id;

    private String name;
}
