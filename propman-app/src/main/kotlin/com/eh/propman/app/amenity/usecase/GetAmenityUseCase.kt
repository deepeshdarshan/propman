package com.eh.propman.app.amenity.usecase

import com.eh.propman.app.amenity.adapter.AmenityAdapter
import com.eh.propman.app.amenity.modal.AmenityResponse
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class GetAmenityUseCase(private val amenityAdapter: AmenityAdapter) {

    @QueryMapping
    fun getAmenityById(@Argument id: Long): AmenityResponse? {
        return amenityAdapter.getById(id)
    }

}