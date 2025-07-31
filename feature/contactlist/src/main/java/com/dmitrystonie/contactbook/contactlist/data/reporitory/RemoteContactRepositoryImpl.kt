package com.dmitrystonie.contactbook.contactlist.data.reporitory

import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contactlist.data.datasource.remote.converter.toContact
import com.dmitrystonie.contactbook.contactlist.data.datasource.remote.RemoteContactDataSource
import com.dmitrystonie.contactbook.contactlist.domain.repository.RemoteContactRepository
import javax.inject.Inject

class RemoteContactRepositoryImpl @Inject constructor(private val dataSource: RemoteContactDataSource) :
    RemoteContactRepository {
    override suspend fun getContacts(): List<Contact> {
        val response = dataSource.getContacts()
        return response.results.map { contactDto -> contactDto.toContact() }
    }
}