package com.eh.propman.infra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity(name = "property")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "type")
@ToString(exclude = "type")
@Builder(setterPrefix = "with", toBuilder = true)
public class Property implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Column(name = Property_.NAME, nullable = false)
    private String name;

    @Column(name = Property_.PRICE, nullable = false)
    private Double price;

    @Column(name = Property_.RATING, nullable = false)
    private Integer rating;

    @Column(name = Property_.PREFERENCE, nullable = false)
    private Integer preference;

    @Column(name = Property_.URL)
    private String url;

    @Column(name = Property_.DESCRIPTION)
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    private PropertyType type;
}
