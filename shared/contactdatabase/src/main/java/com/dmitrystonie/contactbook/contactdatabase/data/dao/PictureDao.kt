package com.dmitrystonie.contactbook.contactdatabase.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmitrystonie.contactbook.contactdatabase.data.entity.PictureEntity

@Dao
interface PictureDao {
    @Query("SELECT * FROM ${PictureEntity.Companion.TABLE_NAME} WHERE ${PictureEntity.Companion.CONTACT_ID_NAME} = :id")
    suspend fun getByContactId(id: Long): PictureEntity

    @Insert(entity = PictureEntity::class, onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(picture: PictureEntity): Long

    @Delete
    suspend fun delete(picture: PictureEntity)
}