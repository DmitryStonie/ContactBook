package com.dmitrystonie.contactbook.contactinfo.domain.usecase

import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contactinfo.domain.repository.ContactRepository
import javax.inject.Inject

class GetContactUseCase @Inject constructor(
    private val repository: ContactRepository,
) : suspend (Long) -> Contact by { id: Long -> repository.getContact(id) }
