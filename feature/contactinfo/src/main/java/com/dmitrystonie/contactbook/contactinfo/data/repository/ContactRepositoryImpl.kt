package com.dmitrystonie.contactbook.contactinfo.data.repository

import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contactinfo.data.datasource.ContactDataSource
import com.dmitrystonie.contactbook.contactinfo.domain.repository.ContactRepository
import javax.inject.Inject

class ContactRepositoryImpl @Inject() constructor(private val dataSource: ContactDataSource) : ContactRepository {
    override suspend fun getContact(id: Long): Contact = dataSource.getContact(id)
}