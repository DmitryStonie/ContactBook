package com.dmitrystonie.contactbook.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.dmitrystonie.contactbook.component.ui.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SquareImage(modifier: Modifier = Modifier, url: String?, description: String) {
    GlideImage(
        model = url, contentDescription = description,
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop,
        loading = placeholder(R.drawable.contact),
        failure = placeholder(R.drawable.contact),
    )
}

@Preview
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SquareImagePreview() {
    SquareImage(
        url = null, description = "Фото Иванов Иван Иванович", modifier = Modifier.size(300.dp)
    )
}