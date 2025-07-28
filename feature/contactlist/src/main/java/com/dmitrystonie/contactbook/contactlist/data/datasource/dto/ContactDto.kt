package com.dmitrystonie.contactbook.contactlist.data.datasource.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContactDto(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    @SerialName("dob") val birthday: Birthday,
    val registered: Registration,
    val phone: String,
    @SerialName("cell") val cellphone: String,
    val id: Id,
    val picture: Picture,
    val nat: String,
)
