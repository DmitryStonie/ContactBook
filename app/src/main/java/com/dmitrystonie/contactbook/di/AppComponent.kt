package com.dmitrystonie.contactbook.di

import android.content.Context
import com.dmitrystonie.contactbook.contactlist.di.ContactListModule
import com.dmitrystonie.contactbook.contactlist.presentation.ViewModelFactory
import com.dmitrystonie.contactbook.di.database.DatabaseModule
import com.dmitrystonie.contactbook.di.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, DatabaseModule::class, ContactListModule::class])
@Singleton
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun viewModelsFactory() : ViewModelFactory
}