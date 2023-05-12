package com.mynotes.core.contracts.mappers

interface BaseMapper<Target, Domain> {

    fun toDomain(model: Target): Domain
    fun fromDomain(model: Domain): Target
}
