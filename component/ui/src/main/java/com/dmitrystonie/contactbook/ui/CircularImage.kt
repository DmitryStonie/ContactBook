package com.dmitrystonie.contactbook.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.dmitrystonie.contactbook.component.theme.BgSecondary
import com.dmitrystonie.contactbook.component.ui.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CircularImage(modifier: Modifier = Modifier, url: String?, description: String) {
    GlideImage(
        model = url, contentDescription = description,
        modifier = modifier.clip(CircleShape).border(width = 2.dp, shape = CircleShape, color = BgSecondary),
        contentScale = ContentScale.Fit,
        loading = placeholder(R.drawable.contact),
        failure = placeholder(R.drawable.contact),
    )
}

@Preview
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CircularImagePreview() {
    CircularImage(
        url = null,
        description = "Фото Иванов Иван Иванович",
        modifier = Modifier.size(60.dp)
    )
}