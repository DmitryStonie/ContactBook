package com.dmitrystonie.contactbook.contactlist.domain.usecase

import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contactlist.domain.repository.ContactRepository
import javax.inject.Inject

class GetContactsListUseCase @Inject constructor(private val repository: ContactRepository) :
    suspend () -> List<Contact> by { repository.getContacts() }
