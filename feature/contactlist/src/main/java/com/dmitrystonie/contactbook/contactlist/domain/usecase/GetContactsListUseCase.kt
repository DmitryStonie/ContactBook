package com.dmitrystonie.contactbook.contactlist.domain.usecase

import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contactlist.data.reporitory.ContactRepositoryImpl
import javax.inject.Inject

class GetContactsListUseCase @Inject constructor(val repository: ContactRepositoryImpl){
    suspend fun invoke(): List<Contact>{
        return repository.getContacts()
    }
}