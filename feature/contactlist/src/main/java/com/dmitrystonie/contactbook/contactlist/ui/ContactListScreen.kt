package com.dmitrystonie.contactbook.contactlist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel

@Composable
fun ContactListScreen(
    onContactClick: (id: Int) -> Unit,
) {
    val viewModel = ContactsListViewModel()


//    val state by viewModel.state.observeAsState(ContactsListScreenState.Loading)

    ContactList(
        modifier = Modifier.fillMaxSize(), contacts = listOf(), onContactClick = onContactClick
    )
}