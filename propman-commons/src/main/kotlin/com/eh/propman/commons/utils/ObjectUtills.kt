package com.eh.propman.commons.utils

import kotlin.reflect.full.memberProperties

object ObjectUtils {
    fun <T : Any> copyProperties(source: T, target: T) {
        val sourceProperties = source::class.memberProperties
        val targetProperties = target::class.memberProperties

        sourceProperties.forEach { sourceProperty ->
            val sourceValue = sourceProperty.getter.call(source)
            if (sourceValue != null) {
                val targetProperty = targetProperties.find { it.name == sourceProperty.name }
                targetProperty?.let {
                    if (it is kotlin.reflect.KMutableProperty<*>) {
                        it.setter.call(target, sourceValue)
                    }
                }
            }
        }
    }
}