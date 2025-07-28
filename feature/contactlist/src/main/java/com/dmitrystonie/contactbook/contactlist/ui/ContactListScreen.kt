package com.dmitrystonie.contactbook.contactlist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ContactListScreen(onContactClick: (id: Int) -> Unit){
    ContactList(
        modifier = Modifier.fillMaxSize(),
        contacts = listOf(),
        onContactClick = onContactClick
    )
}