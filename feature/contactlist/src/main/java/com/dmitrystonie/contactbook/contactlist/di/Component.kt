package com.dmitrystonie.contactbook.contactlist.di

import android.content.Context
import com.dmitrystonie.contactbook.contactlist.presentation.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import jakarta.inject.Scope

@AppScope
@Component(modules = [ContactListModule::class, PresentationModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun viewModelsFactory() : ViewModelFactory
}

@Scope
annotation class AppScope