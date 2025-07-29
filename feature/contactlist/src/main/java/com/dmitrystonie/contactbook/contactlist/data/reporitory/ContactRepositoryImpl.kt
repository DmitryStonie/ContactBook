package com.dmitrystonie.contactbook.contactlist.data.reporitory

import android.util.Log
import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contactlist.data.converter.toContact
import com.dmitrystonie.contactbook.contactlist.data.datasource.ContactDataSource
import com.dmitrystonie.contactbook.contactlist.domain.repository.ContactRepository
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(val dataSource: ContactDataSource) : ContactRepository {
    override suspend fun getContacts(): List<Contact> {
        val response = dataSource.getContacts()
        return response.results.map{ contactDto -> contactDto.toContact()}
    }
}