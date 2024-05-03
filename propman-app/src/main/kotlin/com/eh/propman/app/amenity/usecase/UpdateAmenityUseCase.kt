package com.eh.propman.app.amenity.usecase

import com.eh.propman.app.amenity.adapter.AmenityAdapter
import com.eh.propman.app.amenity.modal.AmenityResponse
import com.eh.propman.app.amenity.modal.AmenityUpdateRequest
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class UpdateAmenityUseCase(private val amenityAdapter: AmenityAdapter) {

    @MutationMapping
    fun createAmenity(@Argument request: AmenityUpdateRequest): AmenityResponse {
        return amenityAdapter.update(request)
    }
}