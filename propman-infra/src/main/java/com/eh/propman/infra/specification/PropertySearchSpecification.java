package com.eh.propman.infra.specification;

import com.eh.propman.infra.entity.Amenity_;
import com.eh.propman.infra.entity.Property;
import com.eh.propman.infra.entity.PropertyType_;
import com.eh.propman.infra.entity.Property_;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Objects;

public class PropertySearchSpecification {

    public static Specification<Property> byName(Collection<String> names) {
        return (root, query, cb) -> CollectionUtils.isEmpty(names)
                ? cb.conjunction()
                : cb.or(names.stream()
                .map(name -> cb.like(cb.lower(root.get(Property_.NAME)), "%" + name.toLowerCase() + "%"))
                .toList()
                .toArray(new Predicate[0])
        );
    }

    public static Specification<Property> byRating(Collection<Integer> ratings) {
        return (root, query, cb) -> CollectionUtils.isEmpty(ratings)
                ? cb.conjunction()
                : root.get(Property_.RATING).in(ratings);
    }

    public static Specification<Property> byPreference(Collection<Integer> preferences) {
        return (root, query, cb) -> CollectionUtils.isEmpty(preferences)
                ? cb.conjunction()
                : root.get(Property_.PREFERENCE).in(preferences);
    }

    public static Specification<Property> byPrice(Double price) {
        return (root, query, cb) -> Objects.isNull(price)
                ? cb.conjunction()
                : cb.lessThanOrEqualTo(root.get(Property_.PRICE), price);
    }

    public static Specification<Property> byType(Collection<Long> typeIds) {
        return (root, query, cb) -> CollectionUtils.isEmpty(typeIds)
                ? cb.conjunction()
                : root.get(Property_.TYPE).get(PropertyType_.ID).in(typeIds);
    }

    public static Specification<Property> byAmenity(Collection<Long> amenityIds) {
        return (root, query, cb) -> CollectionUtils.isEmpty(amenityIds)
                ? cb.conjunction()
                : root.get(Property_.AMENITIES).get(Amenity_.ID).in(amenityIds);
    }
}
