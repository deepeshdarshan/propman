package com.eh.propman.commons.utils;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

@Service
public class CommonsUtils {

    public static final String CLASS = "class";

    public static void copyProperties(final Object source, final Object dest) {
        Objects.requireNonNull(source, "Source object can't be null");
        Objects.requireNonNull(dest, "Destination object can't be null");
        Predicate<Map.Entry<String, Object>> keyShouldNotBeClass = entry -> !entry.getKey().equals(CLASS);
        Predicate<Map.Entry<String, Object>> valueShouldNotBeNull = entry -> entry.getValue() != null;
        Predicate<Map.Entry<String, Object>> filter = keyShouldNotBeClass.and(valueShouldNotBeNull);

        try {
            PropertyUtils.describe(source)
                    .entrySet().stream()
                    .filter(filter)
                    .forEach(obj -> {
                        try {
                            setProperty(dest, obj.getKey(), obj.getValue());
                        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
