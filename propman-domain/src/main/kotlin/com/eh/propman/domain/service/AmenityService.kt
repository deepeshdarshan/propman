package com.eh.propman.domain.service

import com.eh.propman.domain.data.AmenityData

interface AmenityService {

        fun saveOrUpdate(data: AmenityData): AmenityData

        fun getById(id: Long): AmenityData

        fun getAll(): List<AmenityData>

        fun deleteById(id: Long): Long

        fun update(data: AmenityData): AmenityData
}