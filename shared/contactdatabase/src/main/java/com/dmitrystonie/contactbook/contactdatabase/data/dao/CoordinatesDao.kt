package com.dmitrystonie.contactbook.contactdatabase.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmitrystonie.contactbook.contactdatabase.data.entity.CoordinatesEntity

@Dao
interface CoordinatesDao {
    @Query("SELECT * FROM ${CoordinatesEntity.Companion.TABLE_NAME} WHERE ${CoordinatesEntity.Companion.CONTACT_ID_NAME} = :id")
    suspend fun getByContactId(id: Long): CoordinatesEntity

    @Insert(entity = CoordinatesEntity::class, onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(coordinates: CoordinatesEntity): Long

    @Delete
    suspend fun delete(coordinates: CoordinatesEntity)
}