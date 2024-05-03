package com.eh.propman.app.amenity.usecase

import com.eh.propman.app.amenity.adapter.AmenityAdapter
import com.eh.propman.app.amenity.modal.AmenityCreateRequest
import com.eh.propman.app.amenity.modal.AmenityResponse
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class CreateAmenityUseCase(private val amenityAdapter: AmenityAdapter) {

    @MutationMapping
    fun createAmenity(@Argument request: AmenityCreateRequest): AmenityResponse {
        return amenityAdapter.save(request)
    }

}