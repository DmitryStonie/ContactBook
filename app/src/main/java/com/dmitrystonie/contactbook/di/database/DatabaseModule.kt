package com.dmitrystonie.contactbook.di.database

import android.content.Context
import androidx.room.Room
import com.dmitrystonie.contactbook.contactdatabase.data.database.ContactDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        context: Context,
    ): ContactDatabase {
        return Room.databaseBuilder(
            context,
            ContactDatabase::class.java,
            "app_database",
        ).build()
    }

    @Provides
    fun provideContactDao(database: ContactDatabase) = database.contactDao()

    @Provides
    fun provideCoordinatesDao(database: ContactDatabase) = database.coordinatesDao()

    @Provides
    fun provideLocationDao(database: ContactDatabase) = database.locationDao()

    @Provides
    fun providePictureDao(database: ContactDatabase) = database.pictureDao()

    @Provides
    fun provideStreetDao(database: ContactDatabase) = database.streetDao()
}