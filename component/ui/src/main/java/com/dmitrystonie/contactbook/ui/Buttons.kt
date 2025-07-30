package com.dmitrystonie.contactbook.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.contactbook.component.theme.ButtonContent
import com.dmitrystonie.contactbook.component.theme.PlaceActionColor
import com.dmitrystonie.contactbook.component.ui.R

@Composable
fun ActionButton(modifier: Modifier = Modifier, onClick: () -> Unit, colors: ButtonColors, iconPainter: Painter, iconDescription: String) {
    Button(
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
        shape = CircleShape,
        colors = colors,
        content = {
            Icon(
                painter = iconPainter,
                contentDescription = iconDescription,
                modifier = Modifier.fillMaxSize()
            )
        }
    )
}

@Preview
@Composable
fun ActionButtonPreview() {
    val mockColors = ButtonColors(
        containerColor = PlaceActionColor,
        contentColor = ButtonContent,
        disabledContainerColor = PlaceActionColor,
        disabledContentColor = ButtonContent
    )
    ActionButton(
        onClick = {},
        colors = mockColors,
        iconPainter = painterResource(R.drawable.place),
        iconDescription = "Место",
        modifier = Modifier.size(60.dp)
    )
}

