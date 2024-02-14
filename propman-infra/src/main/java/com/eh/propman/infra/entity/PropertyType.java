package com.eh.propman.infra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity(name = "property_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "properties")
@ToString(exclude = "properties")
@Builder(setterPrefix = "with", toBuilder = true)
public class PropertyType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Column(name = PropertyType_.NAME, nullable = false)
    private String name;

    @OneToMany(mappedBy = Property_.TYPE, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Property> properties;
}
