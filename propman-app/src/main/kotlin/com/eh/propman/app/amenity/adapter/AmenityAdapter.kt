package com.eh.propman.app.amenity.adapter

import com.eh.propman.app.amenity.extension.toData
import com.eh.propman.app.amenity.extension.toResponse
import com.eh.propman.app.amenity.modal.AmenityCreateRequest
import com.eh.propman.app.amenity.modal.AmenityResponse
import com.eh.propman.app.amenity.modal.AmenityUpdateRequest
import com.eh.propman.app.shared.helper.AdapterHelper
import com.eh.propman.app.shared.modal.Result
import com.eh.propman.app.shared.modal.Status
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

    fun deleteById(id: Long): Result {
        val amenityId = amenityService.deleteById(id)
        return Result.builder().withId(amenityId).withStatus(Status.SUCCESS).build()
    }

    fun getById(id: Long): AmenityResponse {
        val amenity = amenityService.getById(id)
        return amenity.toResponse()
    }
}