package com.dmitrystonie.contactbook.contactinfo.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.dmitrystonie.contactbook.contactinfo.presentation.ContactScreenState
import com.dmitrystonie.contactbook.contactinfo.presentation.ContactViewModel
import com.dmitrystonie.contactbook.ui.ErrorIndicator
import com.dmitrystonie.leasingapp.component.ui.ProgressIndicator

@Composable
fun ContactScreen(
    viewModel: ContactViewModel,
    onBackClick: () -> Unit,
    onEmailClick: (email: String) -> Unit,
    contactId: Long,
    onPhoneClick: (phone: String) -> Unit,
    onSmsClick: (sms: String) -> Unit,
    onLocationClick: (latitude: String, longitude: String) -> Unit
) {
    val state by viewModel.state.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.loadContact(contactId)
    }
    Column {
        TopBar(
            onBackClick = onBackClick
        )
        when (val currentState = state) {
            is ContactScreenState.Content -> {
                ContactInfo(
                    currentState.contact, onEmailClick = onEmailClick,
                    onPhoneClick = onPhoneClick,
                    onSmsClick = onSmsClick,
                    onLocationClick = onLocationClick
                )
            }

            is ContactScreenState.Loading -> ProgressIndicator()
            is ContactScreenState.Error -> ErrorIndicator(
                message = currentState.message
            )

            else -> {
                Log.d("INFO-CONTACT", "$currentState")
                Column { }
            }
    }
    }

}
