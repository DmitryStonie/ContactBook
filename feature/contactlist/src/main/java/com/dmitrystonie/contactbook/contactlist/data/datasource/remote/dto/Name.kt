package com.dmitrystonie.contactbook.contactlist.data.datasource.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val title: String,
    val first: String,
    val last: String,
)
