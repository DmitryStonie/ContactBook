package com.dmitrystonie.contactbook.contactinfo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contact.domain.Coordinates
import com.dmitrystonie.contactbook.contact.domain.Location
import com.dmitrystonie.contactbook.contact.domain.Picture
import com.dmitrystonie.contactbook.contact.domain.Street
import com.dmitrystonie.contactbook.feature.contactinfo.R

@Composable
fun ContactInfo(
    contact: Contact,
    onEmailClick: (email: String) -> Unit,
    onPhoneClick: (phone: String) -> Unit,
    onSmsClick: (sms: String) -> Unit,
    onLocationClick: (latitude: String, longitude: String) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f, fill = false)
        ) {
            ImageField(
                name = contact.name,
                imageUrl = contact.picture.largeUrl
            )

            PhoneField(
                phone = contact.phone, onPhoneClick = onPhoneClick, onSmsClick = onSmsClick,
                subtitle = stringResource(R.string.mobile_phone_subtitle)
            )

            PhoneField(
                phone = contact.cellphone, onPhoneClick = onPhoneClick, onSmsClick = onSmsClick,
                subtitle = stringResource(R.string.cellphone_phone_subtitle)
            )

            EmailField(
                email = contact.email, onEmailClick = onEmailClick
            )

            PlaceField(
                place = "${contact.location.street.number}, ${contact.location.street.name}, ${contact.location.city}, ${contact.location.country}",
                coordinates = contact.location.coordinates,
                onLocationClick = onLocationClick
            )

        }
    }
}

@Preview
@Composable
fun ContactInfoPreview() {
    val contactMock = Contact(
        id = 1,
        gender = "male",
        name = "asdsdfa",
        location = Location(
            street = Street(
                number = 1173, name = "Højstrupvej"
            ),
            city = "Nørrebro",
            state = "Nordjylland",
            country = "Denmark",
            postcode = "dsfds",
            coordinates = Coordinates(
                latitude = "-45.7555", longitude = "-142.1687"
            ),
        ),
        birthday = "1982-07-02",
        email = "alexander.rasmussen@example.com",
        phone = "19924371",
        cellphone = "26561423",
        picture = Picture(
            largeUrl = "fds", mediumUrl = "gfdsafds", thumbnailUrl = "fdsfa"
        )
    )

    ContactInfo(
        contact = contactMock,
        onEmailClick = { },
        onPhoneClick = { },
        onSmsClick = {},
        onLocationClick = {_,_->})
}