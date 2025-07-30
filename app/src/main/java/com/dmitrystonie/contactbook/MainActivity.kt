package com.dmitrystonie.contactbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dmitrystonie.contactbook.component.theme.ContactBookTheme
import com.dmitrystonie.contactbook.contactinfo.presentation.ContactViewModel
import com.dmitrystonie.contactbook.contactinfo.presentation.ContactViewModelFactory
import com.dmitrystonie.contactbook.contactinfo.presentation.EmailSender
import com.dmitrystonie.contactbook.contactinfo.presentation.LocationLooker
import com.dmitrystonie.contactbook.contactinfo.presentation.PhoneDialer
import com.dmitrystonie.contactbook.contactinfo.presentation.SmsSender
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModel
import com.dmitrystonie.contactbook.contactlist.presentation.ContactsListViewModelFactory
import com.dmitrystonie.contactbook.ui.MainScreen

class MainActivity : ComponentActivity() {
    lateinit var contactListViewModelFactory: ContactsListViewModelFactory
    lateinit var contactViewModelFactory: ContactViewModelFactory
    lateinit var contactsListViewModel: ContactsListViewModel
    lateinit var contactViewModel: ContactViewModel
    lateinit var emailSender: EmailSender
    lateinit var locationLooker: LocationLooker
    lateinit var phoneDialer: PhoneDialer
    lateinit var smsSender: SmsSender


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contactListViewModelFactory = (applicationContext as ContactBookApplication).appComponent.contactListViewModelsFactory()
        contactViewModelFactory = (applicationContext as ContactBookApplication).appComponent.contactViewModelsFactory()

        contactsListViewModel = contactListViewModelFactory.create(ContactsListViewModel::class.java)
        contactViewModel = contactViewModelFactory.create(ContactViewModel::class.java)

        emailSender = EmailSender(this)
        locationLooker = LocationLooker(this)
        phoneDialer = PhoneDialer(this)
        smsSender = SmsSender(this)

        enableEdgeToEdge()
        setContent {
            ContactBookTheme {
                MainScreen(
                    contactsListViewModel, contactViewModel,
                    onEmailClick = { email -> emailSender.sendEmail(arrayOf(email)) },
                    onPhoneClick = { phone -> phoneDialer.dialPhoneNumber(phone)},
                    onSmsClick = {phone -> smsSender.composeSmsMessage(phone)},
                    onLocationClick = {latitude, longitude -> locationLooker.showLocation(latitude, longitude)}
                )
            }
        }
    }
}