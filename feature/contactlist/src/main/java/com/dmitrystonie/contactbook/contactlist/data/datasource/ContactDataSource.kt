package com.dmitrystonie.contactbook.contactlist.data.datasource

import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contactlist.data.datasource.dto.ContactsResponse
import javax.inject.Inject

class ContactDataSource @Inject constructor(val service: ContactService) {
    suspend fun getContacts(): ContactsResponse = service.getContacts()
}