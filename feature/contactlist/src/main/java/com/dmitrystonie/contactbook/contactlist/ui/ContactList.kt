package com.dmitrystonie.contactbook.contactlist.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contact.domain.Coordinates
import com.dmitrystonie.contactbook.contact.domain.Location
import com.dmitrystonie.contactbook.contact.domain.Picture
import com.dmitrystonie.contactbook.contact.domain.Street
import kotlin.collections.MutableList

@Composable
fun ContactList(modifier: Modifier = Modifier, contacts: List<Contact>, onContactClick: (id: Int) -> Unit) {
    // mock
//    val contacts = MutableList(20) {
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
//    }
    LazyColumn(modifier = modifier) {
        items(contacts) { contact ->
            ContactElement(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(true, onClick = { onContactClick(contact.id) }),
                imageUrl = contact.picture.thumbnailUrl,
                name = contact.name,
                location = "${contact.location.street.number}, ${contact.location.street.name}",
                phone = contact.phone,
            )
        }
    }
}

@Preview
@Composable
fun ContactListPreview() {
    val contactsMock = MutableList(20) {
        Contact(
            id = 1,
            gender = "male",
            name =
                "Mr Alexander Rasmussen"
            ,
            location = Location(
                street = Street(
                    number = 1173, name = "Højstrupvej"
                ),
                city = "Nørrebro",
                state = "Nordjylland",
                country = "Denmark",
                postcode = "33092",
                coordinates = Coordinates(
                    latitude = "-45.7555", longitude = "-142.1687"
                ),
            ),
            birthday = "1982-07-02",
            email = "alexander.rasmussen@example.com",
            phone = "19924371",
            cellphone = "26561423",
            picture = Picture(
                largeUrl = "",
                mediumUrl = "",
                thumbnailUrl = "https://randomuser.me/api/portraits/thumb/men/19.jpg"
            )
        )
    }
    ContactList(
        modifier = Modifier.fillMaxSize(), contacts = contactsMock,
        onContactClick = { }
    )
}