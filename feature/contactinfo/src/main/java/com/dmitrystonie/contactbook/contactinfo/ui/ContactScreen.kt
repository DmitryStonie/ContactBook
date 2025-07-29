package com.dmitrystonie.contactbook.contactinfo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contact.domain.Coordinates
import com.dmitrystonie.contactbook.contact.domain.Location
import com.dmitrystonie.contactbook.contact.domain.Street
import com.dmitrystonie.contactbook.ui.SquareImage

@Composable
fun ContactScreen(id: Long, onBackClick: () -> Unit) {
//    //remove, mock
//    val contact =
//        Contact(
//            id = 1,
//            gender = "male",
//            name = Name(
//                title = "Mr", first = "Alexander", last = "Rasmussen"
//            ),
//            location = Location(
//                street = Street(
//                    number = 1173, name = "Højstrupvej"
//                ),
//                city = "Nørrebro",
//                state = "Nordjylland",
//                country = "Denmark",
//                postcode = 33092,
//                coordinates = Coordinates(
//                    latitude = "-45.7555", longitude = "-142.1687"
//                ),
//            ),
//            birthday = "1982-07-02",
//            email = "alexander.rasmussen@example.com",
//            phone = "19924371",
//            cellphone = "26561423",
//            picture = "https://randomuser.me/api/portraits/thumb/men/19.jpg"
//        )
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        Column(
//            modifier = Modifier
//                .verticalScroll(rememberScrollState())
//                .weight(weight = 1f, fill = false)
//        ) {
//
//            SquareImage(
//                url = contact.picture,
//                description = "${contact.name.title} ${contact.name.first} ${contact.name.last}"
//            )
//
//            PhoneField(phone = contact.phone, onPhoneClick = {}, onSmsClick = {})
//
//            EmailField(
//                email = contact.email, onEmailClick = {})
//
//            PlaceField(
//                place = "${contact.location.street.number}, ${contact.location.street.name}",
//                onPlaceClick = {})
//
//        }
//    }
}

@Preview
@Composable
fun ContactScreenPreview() {
//    val contactMock =
//        Contact(
//            id = 1,
//            gender = "male",
//            name = Name(
//                title = "Mr", first = "Alexander", last = "Rasmussen"
//            ),
//            location = Location(
//                street = Street(
//                    number = 1173, name = "Højstrupvej"
//                ),
//                city = "Nørrebro",
//                state = "Nordjylland",
//                country = "Denmark",
//                postcode = 33092,
//                coordinates = Coordinates(
//                    latitude = "-45.7555", longitude = "-142.1687"
//                ),
//            ),
//            birthday = "1982-07-02",
//            email = "alexander.rasmussen@example.com",
//            phone = "19924371",
//            cellphone = "26561423",
//            picture = "https://randomuser.me/api/portraits/thumb/men/19.jpg"
//        )
//
//    ContactScreen(
//        id = 1,
//        onBackClick = {}
//    )
}