package com.eh.propman.commons.error;

public enum ErrorTypes {

    NOT_FOUND("Not Found"),

    PROPERTY_NOT_FOUND("Property Not Found"),

    PROPERTY_TYPE_NOT_FOUND("Property Type Not Found"),

    AMENITY_NOT_FOUND("Amenity Not Found"),

    INVALID_PROPERTY("Invalid Property Id"),

    INVALID_PROPERTY_TYPE("Invalid Property Type Id"),

    INTERNAL_ERROR("Something went wrong");

    ErrorTypes(String s) {
    }
}
