package com.dmitrystonie.contactbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dmitrystonie.contactbook.component.theme.ContactBookTheme
import com.dmitrystonie.contactbook.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactBookTheme {
                MainScreen()
            }
        }
    }
}