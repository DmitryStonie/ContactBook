package com.dmitrystonie.contactbook.contactlist.data.datasource.dto

import kotlinx.serialization.Serializable

@Serializable
data class Registration(
    val date: String,
    val age: Int
)
