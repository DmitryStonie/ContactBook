package com.dmitrystonie.contactbook.contactlist.domain.repository

import com.dmitrystonie.contactbook.contact.domain.Contact

interface RemoteContactRepository {
    suspend fun getContacts(): List<Contact>
}