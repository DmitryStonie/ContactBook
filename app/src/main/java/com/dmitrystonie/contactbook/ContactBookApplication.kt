package com.dmitrystonie.contactbook

import android.app.Application
import com.dmitrystonie.contactbook.di.AppComponent
import com.dmitrystonie.contactbook.di.DaggerAppComponent


class ContactBookApplication : Application() {

        lateinit var appComponent: AppComponent
            private set

        override fun onCreate() {
            super.onCreate()
            appComponent = DaggerAppComponent.factory().create(applicationContext)
        }
    }