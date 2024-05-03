package com.eh.propman.domain.extension

import com.eh.propman.domain.data.AmenityData
import com.eh.propman.infra.entity.Amenity

fun AmenityData.toEntity(): Amenity {
    return Amenity.builder().withId(this.id).withName(this.name).build();
}

fun Amenity.toData(): AmenityData {
    return AmenityData(id = this.id, name = this.name)
}