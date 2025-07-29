package com.dmitrystonie.contactbook.contactdatabase.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = StreetEntity.TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = ContactEntity::class,
        parentColumns = [ContactEntity.ID_COLUMN_NAME],
        childColumns = [CoordinatesEntity.CONTACT_ID_NAME],
        onDelete = ForeignKey.CASCADE,
    )],
)
data class StreetEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = CONTACT_ID_NAME, index = true) val contactId: Long,
    val number: Int,
    val name: String
) {
    companion object {
        const val TABLE_NAME = "streets"
        const val CONTACT_ID_NAME = "contact_id"

    }
}
