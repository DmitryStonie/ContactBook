package com.dmitrystonie.contactbook.contactlist.data.datasource.remote

import com.dmitrystonie.contactbook.contactlist.data.datasource.remote.dto.ContactsResponse
import javax.inject.Inject

class RemoteContactDataSource @Inject constructor(val service: ContactService) {
    suspend fun getContacts(): ContactsResponse = service.getContacts(50)
}