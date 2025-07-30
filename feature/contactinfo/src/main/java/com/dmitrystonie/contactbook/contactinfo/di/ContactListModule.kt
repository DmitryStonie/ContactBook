package com.dmitrystonie.contactbook.contactinfo.di

import com.dmitrystonie.contactbook.contactinfo.presentation.ContactViewModel
import dagger.Module

@Module(includes = [DataModule::class])
interface ContactModule {
    fun contactViewModel(): ContactViewModel.Factory
}

