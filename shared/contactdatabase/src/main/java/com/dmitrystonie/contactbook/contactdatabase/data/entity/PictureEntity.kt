package com.dmitrystonie.contactbook.contactdatabase.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = PictureEntity.TABLE_NAME,     foreignKeys = [ForeignKey(
    entity = ContactEntity::class,
    parentColumns = [ContactEntity.ID_COLUMN_NAME],
    childColumns = [CoordinatesEntity.CONTACT_ID_NAME],
    onDelete = ForeignKey.CASCADE,
)],)
data class PictureEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = CONTACT_ID_NAME, index = true)
    val contactId: Int,
    val largeUrl: String,
    val mediumUrl: String,
    val thumbnailUrl: String,
){
    companion object{
        const val TABLE_NAME = "pictures"
        const val CONTACT_ID_NAME = "contact_id"

    }
}