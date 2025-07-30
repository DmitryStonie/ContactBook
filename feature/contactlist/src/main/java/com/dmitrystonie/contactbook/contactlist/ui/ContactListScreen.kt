package com.dmitrystonie.contactbook.contactlist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListScreenState
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel
import androidx.compose.runtime.getValue
import com.dmitrystonie.contactbook.ui.ErrorIndicator
import com.dmitrystonie.leasingapp.component.ui.ProgressIndicator


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(
    onContactClick: (id: Long) -> Unit,
    viewModel: ContactsListViewModel
) {
    val state by viewModel.state.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.loadContacts()
    }
    Column {
        TopBar(
            onRefreshClick = {viewModel.loadRemoteContacts()}
        )
        PullToRefreshBox(
            isRefreshing = state is ContactsListScreenState.Loading,
            onRefresh = { viewModel.loadRemoteContacts() },
            modifier = Modifier.fillMaxSize()
        ) {
            when (val currentState = state) {
                is ContactsListScreenState.Content -> {
                    ContactList(
                        modifier = Modifier.fillMaxSize(),
                        contacts = currentState.contacts,
                        onContactClick = onContactClick,
                    )
                }

                is ContactsListScreenState.Loading -> ProgressIndicator()
                is ContactsListScreenState.Error -> ErrorIndicator(
                    message = currentState.message
                )

                else -> {}
            }
        }
    }
}
