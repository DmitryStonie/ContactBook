package com.dmitrystonie.contactbook.contactdatabase.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dmitrystonie.contactbook.contactdatabase.data.dao.ContactDao
import com.dmitrystonie.contactbook.contactdatabase.data.dao.CoordinatesDao
import com.dmitrystonie.contactbook.contactdatabase.data.dao.LocationDao
import com.dmitrystonie.contactbook.contactdatabase.data.dao.PictureDao
import com.dmitrystonie.contactbook.contactdatabase.data.dao.StreetDao
import com.dmitrystonie.contactbook.contactdatabase.data.entity.ContactEntity
import com.dmitrystonie.contactbook.contactdatabase.data.entity.CoordinatesEntity
import com.dmitrystonie.contactbook.contactdatabase.data.entity.LocationEntity
import com.dmitrystonie.contactbook.contactdatabase.data.entity.PictureEntity
import com.dmitrystonie.contactbook.contactdatabase.data.entity.StreetEntity


@Database(entities = [ContactEntity::class, CoordinatesEntity::class, LocationEntity::class, PictureEntity::class, StreetEntity::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
    abstract fun coordinatesDao(): CoordinatesDao
    abstract fun locationDao(): LocationDao
    abstract fun pictureDao(): PictureDao
    abstract fun streetDao(): StreetDao
}