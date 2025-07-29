package com.dmitrystonie.contactbook.contactdatabase.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmitrystonie.contactbook.contactdatabase.data.entity.StreetEntity

@Dao
interface StreetDao {
    @Query("SELECT * FROM ${StreetEntity.Companion.TABLE_NAME} WHERE ${StreetEntity.Companion.CONTACT_ID_NAME} = :id")
    suspend fun getByContactId(id: Long): StreetEntity

    @Insert(entity = StreetEntity::class, onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(street: StreetEntity): Long

    @Delete
    suspend fun delete(street: StreetEntity)
}