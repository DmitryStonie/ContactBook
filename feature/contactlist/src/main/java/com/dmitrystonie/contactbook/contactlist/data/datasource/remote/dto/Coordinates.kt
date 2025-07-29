package com.dmitrystonie.contactbook.contactlist.data.datasource.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Coordinates (
    val latitude: String,
    val longitude: String,
)
