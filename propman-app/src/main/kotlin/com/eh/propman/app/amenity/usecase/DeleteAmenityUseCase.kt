package com.eh.propman.app.amenity.usecase

import com.eh.propman.app.amenity.adapter.AmenityAdapter
import com.eh.propman.app.shared.modal.Result
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class DeleteAmenityUseCase(private val amenityAdapter: AmenityAdapter) {

    @QueryMapping
    fun deleteAmenityById(@Argument id: Long): Result {
        return amenityAdapter.deleteById(id)
    }
}