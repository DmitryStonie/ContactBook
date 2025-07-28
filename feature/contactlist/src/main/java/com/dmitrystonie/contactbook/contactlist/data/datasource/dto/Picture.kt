package com.dmitrystonie.contactbook.contactlist.data.datasource.dto

import kotlinx.serialization.Serializable

@Serializable
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String,
)
