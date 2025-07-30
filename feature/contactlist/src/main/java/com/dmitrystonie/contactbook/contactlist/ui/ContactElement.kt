package com.dmitrystonie.contactbook.contactlist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.contactbook.component.ui.Text
import com.dmitrystonie.contactbook.component.ui.Title
import com.dmitrystonie.contactbook.ui.CircularImage

@Composable
fun ContactElement(modifier: Modifier = Modifier, imageUrl: String? = null, name: String, location: String, phone: String){
    Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically, modifier = modifier
        .padding(horizontal = 8.dp, vertical = 12.dp)){
        CircularImage(
            modifier = Modifier.size(60.dp),
            url = imageUrl,
            description = name
        )
        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(start = 16.dp)){
            Title(
                text = name,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = location,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = phone,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview
@Composable
fun ContactElementPreview(){
    ContactElement(
        modifier = Modifier.width(600.dp),
        name = "Иванов Иван Иванович",
        location = "Ленина 22, кв 91",
        phone = "7 632 463 92 73",
    )
}