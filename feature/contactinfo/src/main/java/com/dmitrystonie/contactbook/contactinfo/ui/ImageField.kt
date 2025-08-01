package com.dmitrystonie.contactbook.contactinfo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dmitrystonie.contactbook.component.theme.HalfTransparent
import com.dmitrystonie.contactbook.component.ui.BigTitle
import com.dmitrystonie.contactbook.ui.SquareImage

@Composable
fun ImageField(name: String, imageUrl: String) {
    Box(
        contentAlignment = Alignment.BottomStart,
    ) {
        SquareImage(
            url = imageUrl, description = name
        )
        BigTitle(
            modifier = Modifier.fillMaxWidth().background(HalfTransparent).padding(all = 20.dp),
            text = name,
            color = MaterialTheme.colorScheme.inverseOnSurface
        )
    }
}