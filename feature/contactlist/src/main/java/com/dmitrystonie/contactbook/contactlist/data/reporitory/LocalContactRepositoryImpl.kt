package com.dmitrystonie.contactbook.contactlist.data.reporitory

import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contactlist.data.datasource.local.LocalContactDataSource
import com.dmitrystonie.contactbook.contactlist.domain.repository.LocalContactRepository
import javax.inject.Inject

class LocalContactRepositoryImpl @Inject constructor(private val dataSource: LocalContactDataSource) : LocalContactRepository {
    override suspend fun saveContacts(contacts: List<Contact>) =
        dataSource.saveContacts(contacts)


    override suspend fun getContacts(): List<Contact> = dataSource.getContacts()

}