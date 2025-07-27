package com.dmitrystonie.contactbook.contact.domain

data class Contact(
    val gender: String,
    val name: Name,
    val location: Location,
    val birthday: String,
    val email: String,
    val phone: String,
    val cellphone: String,
    val picture: String,
)
