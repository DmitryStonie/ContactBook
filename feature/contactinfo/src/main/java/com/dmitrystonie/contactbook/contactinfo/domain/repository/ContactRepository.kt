package com.dmitrystonie.contactbook.contactinfo.domain.repository

import com.dmitrystonie.contactbook.contact.domain.Contact

interface ContactRepository {
    suspend fun getContact(id: Long): Contact
}