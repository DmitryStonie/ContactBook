package com.dmitrystonie.contactbook.contactlist.data.datasource.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Timezone(
    val offset: String,
    val description: String,
)
