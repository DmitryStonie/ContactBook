package com.dmitrystonie.contactbook.contactlist.presentation

import com.dmitrystonie.contactbook.contact.domain.Contact

sealed interface ContactsListScreenState {

    data object Initial : ContactsListScreenState

    data object Loading : ContactsListScreenState

    data class Content(val contacts: List<Contact>) : ContactsListScreenState

    data class Error(val message: String) : ContactsListScreenState
}