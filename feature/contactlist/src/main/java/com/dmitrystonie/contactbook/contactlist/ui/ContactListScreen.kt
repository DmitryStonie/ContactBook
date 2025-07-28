package com.dmitrystonie.contactbook.contactlist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dmitrystonie.contactbook.contactlist.di.ContactListComponent
import com.dmitrystonie.contactbook.contactlist.di.daggerViewModel
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListScreenState
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel

@Composable
fun ContactListScreen(onContactClick: (id: Int) -> Unit){
    val viewModel: ContactsListViewModel = daggerViewModel {
        ContactListComponent.builder.buld().getViewModel()
    }
    val state by viewModel.state.observeAsState(ContactsListScreenState.Loading)

    ContactList(
        modifier = Modifier.fillMaxSize(),
        contacts = listOf(),
        onContactClick = onContactClick
    )
}