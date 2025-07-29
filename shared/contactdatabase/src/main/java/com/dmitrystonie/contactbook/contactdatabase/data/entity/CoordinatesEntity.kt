package com.dmitrystonie.contactbook.contactdatabase.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.dmitrystonie.contactbook.contactdatabase.data.entity.ContactEntity.Companion.ID_COLUMN_NAME

@Entity(
    tableName = CoordinatesEntity.TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = ContactEntity::class,
        parentColumns = [ContactEntity.ID_COLUMN_NAME],
        childColumns = [CoordinatesEntity.CONTACT_ID_NAME],
        onDelete = ForeignKey.CASCADE,
    )],
)
data class CoordinatesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = CONTACT_ID_NAME, index = true)
    val contactId: Long,
    val latitude: String,
    val longitude: String,
) {
    companion object {
        const val TABLE_NAME = "coordinates"
        const val CONTACT_ID_NAME = "contact_id"
    }
}
