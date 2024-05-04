package com.eh.propman.app.amenity.extension

import com.eh.propman.app.amenity.modal.AmenityCreateRequest
import com.eh.propman.app.amenity.modal.AmenityResponse
import com.eh.propman.app.amenity.modal.AmenityUpdateRequest
import com.eh.propman.domain.data.AmenityData

fun AmenityCreateRequest.toData(): AmenityData {
    return AmenityData(name = this.name)
}

fun AmenityData.toResponse(): AmenityResponse {
    return AmenityResponse(id = this.id, name = this.name)
}

fun AmenityUpdateRequest.toData(): AmenityData {
    return AmenityData(id = this.id, name = this.name)
}

fun AmenityResponse.toData(): AmenityData {
    return AmenityData(id = this.id, name = this.name)
}

fun List<AmenityResponse>.toData(): List<AmenityData> {
    return this.map { it.toData() }
}