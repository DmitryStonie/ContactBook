package com.dmitrystonie.contactbook.contactlist.di

import com.dmitrystonie.contactbook.contactlist.data.datasource.ContactDataSource
import com.dmitrystonie.contactbook.contactlist.data.datasource.ContactService
import com.dmitrystonie.contactbook.contactlist.data.reporitory.ContactRepositoryImpl
import com.dmitrystonie.contactbook.contactlist.domain.repository.ContactRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

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
        @Provides
        fun provideContactService(
            retrofit: Retrofit
        ): ContactService {
            return retrofit.create(ContactService::class.java)
        }
    }

    @Binds
    fun provideContactRepository(repository: ContactRepositoryImpl): ContactRepository
}
