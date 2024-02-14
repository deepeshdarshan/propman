package com.eh.propman.app.shared.exception;

import graphql.ErrorClassification;

public enum ErrorTypes implements ErrorClassification {

    NOT_FOUND("Not Found"),

    PROPERTY_NOT_FOUND("Property Not Found"),

    PROPERTY_TYPE_NOT_FOUND("Property Type Not Found"),

    INVALID_PROPERTY("Invalid Property Id"),

    INVALID_PROPERTY_TYPE("Invalid Property Type Id");

    ErrorTypes(String s) {
    }
}
