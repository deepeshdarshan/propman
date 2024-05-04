package com.eh.propman.app.amenity.adapter

import com.eh.propman.app.amenity.extension.toData
import com.eh.propman.app.amenity.extension.toResponse
import com.eh.propman.app.amenity.modal.AmenityCreateRequest
import com.eh.propman.app.amenity.modal.AmenityResponse
import com.eh.propman.app.amenity.modal.AmenityUpdateRequest
import com.eh.propman.app.common.modal.AppResult
import com.eh.propman.app.common.modal.AppStatus
import com.eh.propman.app.property.modal.PropertyResponse
import com.eh.propman.domain.service.AmenityService
import com.eh.propman.domain.service.PropertyService
import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AmenityAdapter(
    private val amenityService: AmenityService,
    private val propertyService: PropertyService,
    private val conversionService: ConversionService
) {

    fun save(request: AmenityCreateRequest): AmenityResponse {
        val amenity = amenityService.saveOrUpdate(request.toData())
        return amenity.toResponse()
    }

    fun update(request: AmenityUpdateRequest): AmenityResponse {
        val amenity = amenityService.update(request.toData())
        return amenity.toResponse()
    }


    fun deleteById(id: Long): AppResult {
        val amenityId = amenityService.deleteById(id)
        return AppResult(amenityId, AppStatus.SUCCESS)
    }

    fun getById(id: Long): AmenityResponse {
        val amenity = amenityService.getById(id)
        return amenity.toResponse()
    }

    fun getProperties(amenities: List<AmenityResponse>): Map<AmenityResponse, List<PropertyResponse>> {
        val amenityDataList = amenities.toData()
        val propertiesByAmenity = propertyService.getPropertiesByAmenity(amenityDataList)
        return propertiesByAmenity.entries.associate { entry ->
            entry.key.toResponse() to entry.value.map { conversionService.convert(it, PropertyResponse::class.java)!! }
        }
    }
}