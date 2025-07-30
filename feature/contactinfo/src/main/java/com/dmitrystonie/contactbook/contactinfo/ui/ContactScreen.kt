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
fun ContactScreen(viewModel: ContactViewModel, onBackClick: () -> Unit, contactId: Long) {
    val state by viewModel.state.observeAsState()

    LaunchedEffect(Unit) {
        Log.d("INFO-CONTACT", "launched effect")
        viewModel.loadContact(contactId)
    }
    when (val currentState = state) {
        is ContactScreenState.Content -> {
            Log.d("INFO-CONTACT", "$currentState")
            ContactInfo(currentState.contact)
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
