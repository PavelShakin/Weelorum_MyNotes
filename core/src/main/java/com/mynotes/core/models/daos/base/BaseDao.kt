package com.mynotes.core.models.daos.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.mynotes.core.models.entities.base.BaseEntity

interface BaseDao<T : BaseEntity> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(model: T)

    @Delete
    fun delete(model: T)

    @Delete
    fun delete(model: List<T>)
}
