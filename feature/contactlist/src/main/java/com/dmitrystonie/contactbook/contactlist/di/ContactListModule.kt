package com.dmitrystonie.contactbook.contactlist.di

import com.dmitrystonie.contactbook.contactlist.data.datasource.ContactDataSource
import com.dmitrystonie.contactbook.contactlist.data.datasource.ContactService
import com.dmitrystonie.contactbook.contactlist.data.reporitory.ContactRepositoryImpl
import com.dmitrystonie.contactbook.contactlist.domain.repository.ContactRepository
import com.dmitrystonie.contactbook.contactlist.domain.usecase.GetContactsListUseCase
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel
import com.dmitrystonie.contactbook.contactlist.presentation.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [DataModule::class, PresentationModule::class])
interface ContactListModule {

}

