package com.mynotes.core.contracts.datasource.base

import com.mynotes.core.models.entities.base.BaseEntity

interface ILocalDataSource<T : BaseEntity> {

    fun create(model: T)
    fun update(model: T)
    fun delete(model: T)
    fun delete(model: List<T>)
}
