package com.dmitrystonie.contactbook.contactlist.di

import dagger.Module

@Module(includes = [DataModule::class, PresentationModule::class])
interface ContactListModule