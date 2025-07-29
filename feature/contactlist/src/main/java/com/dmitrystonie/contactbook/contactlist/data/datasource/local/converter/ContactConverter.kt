package com.dmitrystonie.contactbook.contactlist.data.datasource.local.converter

import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contact.domain.Coordinates
import com.dmitrystonie.contactbook.contact.domain.Location
import com.dmitrystonie.contactbook.contact.domain.Picture
import com.dmitrystonie.contactbook.contact.domain.Street
import com.dmitrystonie.contactbook.contactdatabase.data.entity.ContactEntity
import com.dmitrystonie.contactbook.contactdatabase.data.entity.CoordinatesEntity
import com.dmitrystonie.contactbook.contactdatabase.data.entity.LocationEntity
import com.dmitrystonie.contactbook.contactdatabase.data.entity.PictureEntity
import com.dmitrystonie.contactbook.contactdatabase.data.entity.StreetEntity

fun Contact.toContactEntity() = ContactEntity(
    id = this.id,
    gender = this.gender,
    name = this.name,
    birthday = this.birthday,
    email = this.email,
    phone = this.phone,
    cellphone = this.cellphone
)

fun Coordinates.toCoordinatesEntity(contactId: Long) = CoordinatesEntity(
    id = 0,
    contactId = contactId,
    latitude = this.latitude,
    longitude = this.longitude
)

fun Location.toLocationEntity(contactId: Long) = LocationEntity(
    id = 0,
    contactId = contactId,
    city = this.city,
    state = this.state,
    country = this.country,
    postcode = this.postcode
)

fun Picture.toPictureEntity(contactId: Long) = PictureEntity(
    id = 0,
    contactId = contactId,
    largeUrl = this.largeUrl,
    mediumUrl = this.mediumUrl,
    thumbnailUrl = this.thumbnailUrl
)

fun Street.toStreetEntity(contactId: Long) = StreetEntity(
    id = 0,
    contactId = contactId,
    number = this.number,
    name = this.name
)