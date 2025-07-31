package com.dmitrystonie.contactbook.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmitrystonie.contactbook.component.ui.R

val textStyle = TextStyle(
    fontSize = 28.sp,
    fontWeight = FontWeight.W500,
    letterSpacing = 0.sp,
)

@Composable
fun ErrorIndicator(modifier: Modifier = Modifier, message: String) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 120.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(horizontal = 30.dp),
            painter = painterResource(R.drawable.error_icon),
            contentDescription = stringResource(R.string.error_icon_description),
            contentScale = ContentScale.FillWidth,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
        )
        Text(
            text = message,
            modifier = modifier,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = textStyle,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun ErrorIndicatorPreview() {
    ErrorIndicator(
        message = "Что-то пошло не так"
    )
}