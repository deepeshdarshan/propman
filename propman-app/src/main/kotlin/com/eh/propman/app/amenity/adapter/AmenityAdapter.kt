package com.eh.propman.app.amenity.adapter

import com.eh.propman.app.amenity.Extension.toData
import com.eh.propman.app.amenity.Extension.toResponse
import com.eh.propman.app.amenity.modal.AmenityCreateRequest
import com.eh.propman.app.amenity.modal.AmenityResponse
import com.eh.propman.app.amenity.modal.AmenityUpdateRequest
import com.eh.propman.app.shared.helper.AdapterHelper
import com.eh.propman.domain.service.AmenityService
import org.springframework.stereotype.Service

@Service
class AmenityAdapter(private val amenityService: AmenityService): AdapterHelper() {

    fun save(request: AmenityCreateRequest): AmenityResponse {
        val amenity = amenityService.save(request.toData())
        return amenity.toResponse()
    }

    fun update(request: AmenityUpdateRequest): AmenityResponse {
        val amenity = amenityService.update(request.toData())
        return amenity.toResponse()
    }
}