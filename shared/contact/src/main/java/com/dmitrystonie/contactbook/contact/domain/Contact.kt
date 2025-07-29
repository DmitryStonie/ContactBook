package com.dmitrystonie.contactbook.contact.domain

data class Contact(
    val id: Long,
    val gender: String,
    val name: String,
    val location: Location,
    val birthday: String,
    val email: String,
    val phone: String,
    val cellphone: String,
    val picture: Picture,
)
