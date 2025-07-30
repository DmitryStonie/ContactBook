package com.dmitrystonie.contactbook.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dmitrystonie.contactbook.contactinfo.presentation.ContactViewModel
import com.dmitrystonie.contactbook.contactinfo.presentation.ContactViewModelFactory
import com.dmitrystonie.contactbook.contactinfo.ui.ContactRoute
import com.dmitrystonie.contactbook.contactinfo.ui.ContactScreen
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModelFactory
import com.dmitrystonie.contactbook.contactlist.ui.ContactListRoute
import com.dmitrystonie.contactbook.contactlist.ui.ContactListScreen

@Composable
fun MainScreen(contactsListviewModelFactory: ContactsListViewModelFactory, contactViewModelFactory: ContactViewModel.Factory) {
    val navController = rememberNavController()

    Scaffold { paddingValues: PaddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = ContactListRoute,
        ) {
            composable<ContactListRoute> {
                ContactListScreen(
                    onContactClick = { contactId ->
                        navController.navigate(ContactRoute(contactId))
                    },
                    viewModel = contactsListviewModelFactory.create(ContactsListViewModel::class.java)

                )
            }
            composable<ContactRoute> {
                val destination = it.toRoute<ContactRoute>()

                ContactScreen(
                    onBackClick = { navController.navigateUp() },
                    viewModel = contactViewModelFactory.create(destination.contactId)
                )
            }
        }
    }
}