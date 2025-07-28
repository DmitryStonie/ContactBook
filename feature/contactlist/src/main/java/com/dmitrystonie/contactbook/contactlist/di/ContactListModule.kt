package com.dmitrystonie.contactbook.contactlist.di

import com.dmitrystonie.contactbook.contactlist.data.datasource.ContactDataSource
import com.dmitrystonie.contactbook.contactlist.data.reporitory.ContactRepositoryImpl
import com.dmitrystonie.contactbook.contactlist.domain.repository.ContactRepository
import com.dmitrystonie.contactbook.contactlist.domain.usecase.GetContactsListUseCase
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataModule::class])
class ContactListModule {

    @Provides
    @ContactListScreenScope
    fun provideViewModel(useCase: GetContactsListUseCase): ContactsListViewModel =
        ContactsListViewModel(useCase)



}

@Module
private interface DataModule {
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
    @Singleton
    fun provideContactRepository(repository: ContactRepositoryImpl): ContactRepository
}