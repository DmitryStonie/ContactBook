package com.dmitrystonie.contactbook.contactinfo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contact.domain.Coordinates
import com.dmitrystonie.contactbook.contact.domain.Location
import com.dmitrystonie.contactbook.contact.domain.Picture
import com.dmitrystonie.contactbook.contact.domain.Street
import com.dmitrystonie.contactbook.contactinfo.presentation.ContactScreenState
import com.dmitrystonie.contactbook.contactinfo.presentation.ContactViewModel
import com.dmitrystonie.contactbook.ui.SquareImage

@Composable
fun ContactScreen(viewModel: ContactViewModel, onBackClick: () -> Unit) {
    val state by viewModel.state.observeAsState(ContactScreenState.Initial)

    LaunchedEffect(Unit) {
        viewModel.loadContact()
    }
    when (val currentState = state) {
        is ContactScreenState.Content -> {
            ContactInfo(currentState.contact)
        }

        is ContactScreenState.Error, ContactScreenState.Initial, ContactScreenState.Loading -> {
            Column { }
        }
    }

}
