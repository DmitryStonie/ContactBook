package com.dmitrystonie.contactbook.contactlist.di

import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel
import dagger.Component


@Component(
    modules = [ContactListModule::class]
)
@ContactListScreenScope
interface ContactListComponent {

    @Component.Builder
    interface Builder {
        fun build(): ContactListComponent
    }

    fun getViewModel() : ContactsListViewModel
}