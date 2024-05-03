package com.eh.propman.infra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import static com.eh.propman.infra.util.InfraConstants.*;

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

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = PROPERTY_AMENITY,
            joinColumns = @JoinColumn(name = PROPERTY_ID, referencedColumnName = Property_.ID),
            inverseJoinColumns = @JoinColumn(name = AMENITY_ID, referencedColumnName = Amenity_.ID))
    private List<Amenity> amenities;
}
