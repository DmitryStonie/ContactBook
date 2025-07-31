package com.dmitrystonie.contactbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dmitrystonie.contactbook.component.theme.ContactBookTheme
import com.dmitrystonie.contactbook.contactinfo.presentation.ContactViewModel
import com.dmitrystonie.contactbook.contactinfo.presentation.ContactViewModelFactory
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModelFactory
import com.dmitrystonie.contactbook.ui.MainScreen

class MainActivity : ComponentActivity() {
    lateinit var contactListViewModelFactory: ContactsListViewModelFactory
    lateinit var contactViewModelFactory: ContactViewModelFactory
    lateinit var contactsListViewModel: ContactsListViewModel
    lateinit var contactViewModel: ContactViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contactListViewModelFactory =
            (applicationContext as ContactBookApplication).appComponent.contactListViewModelsFactory()
        contactViewModelFactory =
            (applicationContext as ContactBookApplication).appComponent.contactViewModelsFactory()

        contactsListViewModel =
            contactListViewModelFactory.create(ContactsListViewModel::class.java)
        contactViewModel = contactViewModelFactory.create(ContactViewModel::class.java)

        enableEdgeToEdge()
        setContent {
            ContactBookTheme {
                MainScreen(
                    contactsListViewModel,
                    contactViewModel)
            }
        }
    }
}