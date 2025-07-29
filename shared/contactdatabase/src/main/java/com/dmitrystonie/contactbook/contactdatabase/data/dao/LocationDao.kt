package com.dmitrystonie.contactbook.contactdatabase.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmitrystonie.contactbook.contactdatabase.data.entity.LocationEntity

@Dao
interface LocationDao {
    @Query("SELECT * FROM ${LocationEntity.Companion.TABLE_NAME} WHERE ${LocationEntity.Companion.CONTACT_ID_NAME} = :id")
    suspend fun getByContactId(id: Long): LocationEntity

    @Insert(entity = LocationEntity::class, onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(location: LocationEntity): Long

    @Delete
    suspend fun delete(location: LocationEntity)
}