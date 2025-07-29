package com.dmitrystonie.contactbook.contactdatabase.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = LocationEntity.TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = ContactEntity::class,
        parentColumns = [ContactEntity.ID_COLUMN_NAME],
        childColumns = [CoordinatesEntity.CONTACT_ID_NAME],
        onDelete = ForeignKey.CASCADE,
    )],
)
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = CONTACT_ID_NAME, index = true) val contactId: Long,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
) {
    companion object {
        const val TABLE_NAME = "locations"
        const val CONTACT_ID_NAME = "contact_id"

    }
}
