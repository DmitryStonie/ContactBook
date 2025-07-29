package com.dmitrystonie.contactbook.contactdatabase.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmitrystonie.contactbook.contactdatabase.data.entity.ContactEntity

@Dao
interface ContactDao {
    @Query("SELECT * FROM ${ContactEntity.Companion.TABLE_NAME}")
    suspend fun getAll(): List<ContactEntity>

    @Query("SELECT * FROM ${ContactEntity.Companion.TABLE_NAME} WHERE ${ContactEntity.Companion.ID_COLUMN_NAME} = :id")
    suspend fun getById(id: Long): ContactEntity

    @Insert(entity = ContactEntity::class, onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(contacts: List<ContactEntity>)

    @Delete
    suspend fun delete(contact: ContactEntity)
}