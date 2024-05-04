package com.eh.propman.domain.service.impl

import com.eh.propman.commons.utils.ObjectUtils
import com.eh.propman.domain.extension.toData
import com.eh.propman.domain.extension.toEntity
import com.eh.propman.domain.data.AmenityData
import com.eh.propman.domain.service.AmenityService
import com.eh.propman.domain.service.helper.DomainServiceHelper
import com.eh.propman.infra.repository.AmenityRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AmenityDomainService(private val repository: AmenityRepository): DomainServiceHelper(), AmenityService {

    override fun saveOrUpdate(data: AmenityData): AmenityData {
        Objects.requireNonNull(data, "Amenity data cannot be null")
        val amenity = repository.save(data.toEntity())
        return amenity.toData()
    }

    override fun getById(id: Long): AmenityData {
        Objects.requireNonNull(id, "Amenity id cannot be null")
        val amenity = repository.findById(id).orElseThrow { noAmenityFoundException(id) }
        return amenity.toData()
    }

    override fun getAll(): List<AmenityData> {
        val amenities = repository.findAll()
        return amenities.map { it.toData() }
    }

    override fun deleteById(id: Long): Long {
        Objects.requireNonNull(id, "Amenity id cannot be null")
        val amenityData = getById(id)
        repository.deleteById(amenityData.id!!)
        return id
    }

    override fun update(data: AmenityData): AmenityData {
        Objects.requireNonNull(data, "Amenity data cannot be null")
        val amenityData = getById(data.id!!)
        ObjectUtils.copyProperties(data, amenityData)
        return saveOrUpdate(data)
    }
}