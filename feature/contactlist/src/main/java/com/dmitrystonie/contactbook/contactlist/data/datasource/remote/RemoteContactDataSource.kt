package com.dmitrystonie.contactbook.contactlist.data.datasource.remote

import com.dmitrystonie.contactbook.contactlist.data.datasource.remote.dto.ContactsResponse
import javax.inject.Inject

class RemoteContactDataSource @Inject constructor(private val service: ContactService) {
    suspend fun getContacts(): ContactsResponse = service.getContacts(NUM_OF_CONTACTS)

    companion object{
        private const val NUM_OF_CONTACTS = 50
    }
}