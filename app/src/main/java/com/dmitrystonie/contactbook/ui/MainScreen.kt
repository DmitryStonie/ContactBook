package com.dmitrystonie.contactbook.ui

import android.util.Log
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
import com.dmitrystonie.contactbook.contactinfo.ui.ContactRoute
import com.dmitrystonie.contactbook.contactinfo.ui.ContactScreen
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel
import com.dmitrystonie.contactbook.contactlist.ui.ContactListRoute
import com.dmitrystonie.contactbook.contactlist.ui.ContactListScreen

@Composable
fun MainScreen(
    contactsListViewModel: ContactsListViewModel,
    contactViewModel: ContactViewModel,
    onEmailClick: (email: String) -> Unit,
    onPhoneClick: (phone: String) -> Unit,
    onSmsClick: (sms: String) -> Unit,
    onLocationClick: (latitude: String, longitude: String) -> Unit
) {
    val navController = rememberNavController()

    Scaffold { paddingValues: PaddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = ContactListRoute,
        ) {
            composable<ContactListRoute> {
                Log.d("INFO_APP", "creating contactlist viewmodel $contactsListViewModel")
                ContactListScreen(
                    onContactClick = { contactId ->
                        navController.navigate(ContactRoute(contactId))
                    },
                    viewModel = contactsListViewModel

                )
            }
            composable<ContactRoute> {
                val destination = it.toRoute<ContactRoute>()
                Log.d("INFO_APP", "creating contact viewmodel $contactViewModel")
                ContactScreen(
                    onBackClick = { navController.navigateUp() },
                    viewModel = contactViewModel,
                    contactId = destination.contactId,
                    onEmailClick = onEmailClick,
                    onPhoneClick = onPhoneClick,
                    onSmsClick = onSmsClick,
                    onLocationClick = onLocationClick
                )
            }
        }
    }
}