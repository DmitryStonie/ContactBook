package com.dmitrystonie.contactbook.di

import android.content.Context
import com.dmitrystonie.contactbook.contactinfo.di.ContactModule
import com.dmitrystonie.contactbook.contactinfo.presentation.ContactViewModelFactory
import com.dmitrystonie.contactbook.contactlist.di.ContactListModule
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModelFactory
import com.dmitrystonie.contactbook.di.database.DatabaseModule
import com.dmitrystonie.contactbook.di.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, DatabaseModule::class, ContactListModule::class, ContactModule::class])
@Singleton
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
    fun contactListViewModelsFactory() : ContactsListViewModelFactory
    fun contactViewModelsFactory() : ContactViewModelFactory
}