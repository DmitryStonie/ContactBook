package com.dmitrystonie.contactbook.contactinfo.di

import dagger.Module

@Module(includes = [DataModule::class, PresentationModule::class])
interface ContactModule