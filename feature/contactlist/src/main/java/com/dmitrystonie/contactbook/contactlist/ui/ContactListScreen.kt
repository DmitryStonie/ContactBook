package com.dmitrystonie.contactbook.contactlist.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListScreenState
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel
import com.dmitrystonie.contactbook.contactlist.presentation.ViewModelFactory
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color


@Composable
fun ContactListScreen(
    onContactClick: (id: Long) -> Unit,
    viewModel: ContactsListViewModel
) {
    val state by viewModel.state.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.loadContacts()
    }
        when (val currentState = state) {
            is ContactsListScreenState.Content -> {
                Log.d("INFO", "$currentState content")
                ContactList(
                    modifier = Modifier.fillMaxSize(),
                    contacts = currentState.contacts,
                    onContactClick = onContactClick
                )
            }
            else -> {
                Log.d("INFO", "$currentState")
            }
        }
}