package com.dmitrystonie.contactbook.contactlist.data.datasource.dto

import kotlinx.serialization.Serializable

@Serializable
data class Info(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String,

)
