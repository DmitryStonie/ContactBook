package com.dmitrystonie.contactbook.contactlist.data.datasource.remote.converter

import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contact.domain.Coordinates
import com.dmitrystonie.contactbook.contact.domain.Location
import com.dmitrystonie.contactbook.contact.domain.Picture
import com.dmitrystonie.contactbook.contact.domain.Street
import com.dmitrystonie.contactbook.contactlist.data.datasource.remote.dto.ContactDto
import com.dmitrystonie.contactbook.date.toBirthDate


fun ContactDto.toContact(): Contact{
    return Contact(
        id = 0,
        gender = this.gender,
        name = "${this.name.title} ${this.name.first} ${this.name.last}",
        location = this.location.toLocation(),
        birthday = this.birthday.date.toBirthDate(),
        email = this.email,
        phone = this.phone,
        cellphone = this.cellphone,
        picture = picture.toPicture()
    )
}

private fun com.dmitrystonie.contactbook.contactlist.data.datasource.remote.dto.Location.toLocation(): Location{
    return Location(
        street = street.toStreet(),
        city = city,
        state = state,
        country = country,
        postcode = postcode,
        coordinates = coordinates.toCoordinates()
    )
}

private fun com.dmitrystonie.contactbook.contactlist.data.datasource.remote.dto.Coordinates.toCoordinates(): Coordinates{
    return Coordinates(
        latitude = latitude,
        longitude = longitude
    )
}

private fun com.dmitrystonie.contactbook.contactlist.data.datasource.remote.dto.Street.toStreet(): Street{
    return Street(
        number = number,
        name = name
    )
}

private fun com.dmitrystonie.contactbook.contactlist.data.datasource.remote.dto.Picture.toPicture(): Picture{
    return Picture(
        largeUrl = large,
        mediumUrl = medium,
        thumbnailUrl = thumbnail
    )
}