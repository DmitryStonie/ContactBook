package com.dmitrystonie.contactbook.contactlist.di

import com.dmitrystonie.contactbook.contactlist.data.datasource.local.LocalContactDataSource
import com.dmitrystonie.contactbook.contactlist.data.datasource.remote.RemoteContactDataSource
import com.dmitrystonie.contactbook.contactlist.data.datasource.remote.ContactService
import com.dmitrystonie.contactbook.contactlist.data.reporitory.LocalContactRepositoryImpl
import com.dmitrystonie.contactbook.contactlist.data.reporitory.RemoteContactRepositoryImpl
import com.dmitrystonie.contactbook.contactlist.domain.repository.LocalContactRepository
import com.dmitrystonie.contactbook.contactlist.domain.repository.RemoteContactRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface DataModule {
    val remoteContactDataSource: RemoteContactDataSource
    val localContactDataSource: LocalContactDataSource

    companion object {
        @Provides
        fun provideRemoteContactRepositoryImpl(
            dataSource: RemoteContactDataSource,
        ): RemoteContactRepositoryImpl {
            return RemoteContactRepositoryImpl(
                dataSource = dataSource
            )
        }

        @Provides
        fun provideLocalContactRepositoryImpl(
            dataSource: LocalContactDataSource,
        ): LocalContactRepositoryImpl {
            return LocalContactRepositoryImpl(
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
    fun provideRemoteContactRepository(repository: RemoteContactRepositoryImpl): RemoteContactRepository

    @Binds
    fun provideLocalContactRepository(repository: LocalContactRepositoryImpl): LocalContactRepository
}
