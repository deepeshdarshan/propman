package com.eh.propman.infra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "amenity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "properties")
@ToString(exclude = "properties")
@Builder(setterPrefix = "with", toBuilder = true)
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Column(name = Amenity_.NAME, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "amenities", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Property> properties;
}
