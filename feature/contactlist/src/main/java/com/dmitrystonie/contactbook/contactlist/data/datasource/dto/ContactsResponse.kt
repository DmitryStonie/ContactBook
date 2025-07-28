package com.dmitrystonie.contactbook.contactlist.data.datasource.dto

import kotlinx.serialization.Serializable

@Serializable
data class ContactsResponse(
    val results: List<ContactDto>, val info: Info
)