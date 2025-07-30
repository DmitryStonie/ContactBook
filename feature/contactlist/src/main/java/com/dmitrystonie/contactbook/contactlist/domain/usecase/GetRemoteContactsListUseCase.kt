package com.dmitrystonie.contactbook.contactlist.domain.usecase

import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contactlist.domain.repository.LocalContactRepository
import com.dmitrystonie.contactbook.contactlist.domain.repository.RemoteContactRepository
import javax.inject.Inject

class GetRemoteContactsListUseCase @Inject constructor(
    private val remoteRepository: RemoteContactRepository,
    private val localRepository: LocalContactRepository
) : suspend () -> List<Contact> by {
    localRepository.deleteContacts()
    val remoteContacts = remoteRepository.getContacts()
    localRepository.saveContacts(remoteContacts)
    localRepository.getContacts()
}
