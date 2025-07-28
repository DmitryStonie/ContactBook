package com.dmitrystonie.contactbook.di

import com.dmitrystonie.contactbook.di.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, ContactModule::class, ContactListModule::class])
@Singleton
interface AppComponent {

}