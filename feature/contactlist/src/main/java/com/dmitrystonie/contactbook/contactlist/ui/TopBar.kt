package com.dmitrystonie.contactbook.contactlist.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.dmitrystonie.contactbook.feature.contactlist.R
import com.dmitrystonie.leasingapp.component.ui.TopAppBar

@Composable
fun TopBar(onRefreshClick: () -> Unit){
    TopAppBar(
        icon = painterResource(R.drawable.arrow_refresh),
        iconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        description = stringResource(R.string.topbar_refresh_icon_description),
        onClick = onRefreshClick
    )
}