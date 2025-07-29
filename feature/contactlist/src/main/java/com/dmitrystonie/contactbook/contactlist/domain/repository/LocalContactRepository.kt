package com.dmitrystonie.contactbook.contactlist.domain.repository

import com.dmitrystonie.contactbook.contact.domain.Contact

interface LocalContactRepository {
    suspend fun saveContacts(contacts: List<Contact>)
    suspend fun getContacts(): List<Contact>
}