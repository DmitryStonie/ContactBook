package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.dmitrystonie.contactbook.component.theme.BgPrimary
import com.dmitrystonie.contactbook.component.theme.TextPrimary
import com.dmitrystonie.contactbook.component.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    icon: Painter,
    iconColor: Color,
    description: String,
    onClick: () -> Unit,
) {
    TopAppBar(
        title = {},
        actions = {
            IconButton(onClick = onClick) {
                Icon(
                    painter = icon, contentDescription = description, tint = iconColor
                )
            }
        },
        modifier = modifier,
        colors = TopAppBarColors(
            containerColor = BgPrimary,
            scrolledContainerColor = BgPrimary,
            navigationIconContentColor = TextSecondary,
            titleContentColor = TextPrimary,
            actionIconContentColor = TextSecondary,
        ),
        windowInsets = WindowInsets(top = 0.dp),
    )
}
