package com.dmitrystonie.contactbook.contactlist.data.datasource.dto

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val title: String,
    val first: String,
    val last: String,
)
