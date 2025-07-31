package com.dmitrystonie.contactbook.contactlist.di

import androidx.lifecycle.ViewModel
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
interface PresentationModule {

    @Binds
    @IntoMap
    @ContactListViewModelKey(ContactsListViewModel::class)
    fun bindContactsViewModel(contactsViewModel: ContactsListViewModel): ContactsListViewModel

}

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ContactListViewModelKey(val value: KClass<out ViewModel>)
