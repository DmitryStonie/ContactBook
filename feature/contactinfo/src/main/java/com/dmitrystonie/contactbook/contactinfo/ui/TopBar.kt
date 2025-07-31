package com.dmitrystonie.contactbook.contactinfo.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.dmitrystonie.contactbook.feature.contactinfo.R
import com.dmitrystonie.leasingapp.component.ui.TopAppBar

@Composable
fun TopBar(onBackClick: () -> Unit) {
    TopAppBar(
        icon = painterResource(R.drawable.ic_left),
        iconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        description = stringResource(R.string.topbar_back_icon_description),
        onClick = onBackClick
    )
}