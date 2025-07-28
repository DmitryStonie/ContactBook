package com.dmitrystonie.contactbook.contactlist.data.datasource

import com.dmitrystonie.contactbook.contact.domain.Contact
import javax.inject.Inject

class ContactDataSource @Inject constructor(val service: ContactService) {
    suspend fun getContacts(): List<Contact> = service.getContacts()
}