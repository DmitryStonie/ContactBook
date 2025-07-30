package com.dmitrystonie.contactbook.contactinfo.di

import com.dmitrystonie.contactbook.contactinfo.data.datasource.ContactDataSource
import com.dmitrystonie.contactbook.contactinfo.data.repository.ContactRepositoryImpl
import com.dmitrystonie.contactbook.contactinfo.domain.repository.ContactRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    val contactDataSource: ContactDataSource

    companion object {
        @Provides
        fun provideContactRepositoryImpl(
            dataSource: ContactDataSource,
        ): ContactRepositoryImpl {
            return ContactRepositoryImpl(
                dataSource = dataSource
            )
        }
    }

    @Binds
    fun provideContactRepository(repository: ContactRepositoryImpl): ContactRepository
}
