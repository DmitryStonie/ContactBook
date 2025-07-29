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

fun ContactEntity.toContact(locationEntity: LocationEntity, pictureEntity: PictureEntity, streetEntity: StreetEntity, coordinatesEntity: CoordinatesEntity) = Contact(
    id = this.id,
    gender = this.gender,
    name = this.name,
    birthday = this.birthday,
    email = this.email,
    phone = this.phone,
    cellphone = this.cellphone,
    location = locationEntity.toLocation(streetEntity = streetEntity, coordinatesEntity = coordinatesEntity),
    picture = pictureEntity.toPicture()
)

private fun CoordinatesEntity.toCoordinates() = Coordinates(
    latitude = this.latitude,
    longitude = this.longitude
)

private fun LocationEntity.toLocation(streetEntity: StreetEntity, coordinatesEntity: CoordinatesEntity) = Location(
    city = this.city,
    state = this.state,
    country = this.country,
    postcode = this.postcode,
    street = streetEntity.toStreet(),
    coordinates = coordinatesEntity.toCoordinates(),
)

private fun PictureEntity.toPicture() = Picture(
    largeUrl = this.largeUrl,
    mediumUrl = this.mediumUrl,
    thumbnailUrl = this.thumbnailUrl
)

private fun StreetEntity.toStreet() = Street(
    number = this.number,
    name = this.name
)