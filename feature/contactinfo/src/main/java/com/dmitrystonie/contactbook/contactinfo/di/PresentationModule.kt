package com.dmitrystonie.contactbook.contactinfo.di

import androidx.lifecycle.ViewModel
import com.dmitrystonie.contactbook.contactinfo.presentation.ContactViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
interface PresentationModule {

    @Binds
    @IntoMap
    @ContactViewModelKey(ContactViewModel::class)
    fun bindContactsViewModel(contactsViewModel: ContactViewModel): ViewModel

}

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ContactViewModelKey(val value: KClass<out ViewModel>)
