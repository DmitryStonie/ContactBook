package com.dmitrystonie.contactbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dmitrystonie.contactbook.component.theme.ContactBookTheme
import com.dmitrystonie.contactbook.contactlist.presentation.ViewModelFactory
import com.dmitrystonie.contactbook.ui.MainScreen
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = (applicationContext as ContactBookApplication).appComponent.viewModelsFactory()
        enableEdgeToEdge()
        setContent {
            ContactBookTheme {
                MainScreen(viewModelFactory)
            }
        }
    }
}