package com.dmitrystonie.contactbook.contactlist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListScreenState
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel
import com.dmitrystonie.contactbook.contactlist.presentation.ViewModelFactory


@Composable
fun ContactListScreen(
    onContactClick: (id: Int) -> Unit,
    viewModelFactory: ViewModelFactory
) {
    val viewModel = viewModelFactory.create(ContactsListViewModel::class.java)
    val state = viewModel.state.observeAsState(ContactsListScreenState.Loading)

    when(state.value){
        is ContactsListScreenState.Initial -> {
            ContactList(
                modifier = Modifier.fillMaxSize(), contacts = listOf(), onContactClick = onContactClick
            )
        }
        is ContactsListScreenState.Content -> {
            ContactList(
                modifier = Modifier.fillMaxSize(), contacts = (state.value as ContactsListScreenState.Content).contacts, onContactClick = onContactClick
            )
        }

        is ContactsListScreenState.Error -> {
            ContactList(
                modifier = Modifier.fillMaxSize(), contacts = listOf(), onContactClick = onContactClick
            )
        }
        ContactsListScreenState.Loading -> {
            ContactList(
                modifier = Modifier.fillMaxSize(), contacts = listOf(), onContactClick = onContactClick
            )
        }
    }
}