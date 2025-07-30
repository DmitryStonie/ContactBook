package com.dmitrystonie.contactbook.contactinfo.presentation

import com.dmitrystonie.contactbook.contact.domain.Contact

sealed interface ContactScreenState {

    data object Initial : ContactScreenState

    data object Loading : ContactScreenState

    data class Content(val contact: Contact) : ContactScreenState

    data class Error(val message: String) : ContactScreenState
}