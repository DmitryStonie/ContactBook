package com.dmitrystonie.contactbook.contactdatabase.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ContactEntity.TABLE_NAME)
data class ContactEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID_COLUMN_NAME, index = true)
    val id: Long,
    val gender: String,
    val name: String,
    val birthday: String,
    val email: String,
    val phone: String,
    val cellphone: String,

){
    companion object{
        const val TABLE_NAME = "contacts"
        const val ID_COLUMN_NAME = "id"
    }
}