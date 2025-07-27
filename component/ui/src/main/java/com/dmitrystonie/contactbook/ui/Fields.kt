package com.dmitrystonie.contactbook.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.contactbook.component.theme.BgPrimary
import com.dmitrystonie.contactbook.component.theme.PlaceActionColor
import com.dmitrystonie.contactbook.component.theme.TextPrimary
import com.dmitrystonie.contactbook.component.ui.R
import com.dmitrystonie.contactbook.component.ui.Title

@Composable
fun FieldWithIcon(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    actions: @Composable (() -> Unit),
) {
    Row(
        modifier = modifier
            .clickable(true, onClick = onClick)
            .padding(horizontal = 20.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Title(
            text = text,
            color = TextPrimary
        )
        actions()
    }
}

@Preview
@Composable
fun FieldWithIconPreview() {
    val mockColors = ButtonColors(
        containerColor = PlaceActionColor,
        contentColor = BgPrimary,
        disabledContainerColor = PlaceActionColor,
        disabledContentColor = BgPrimary
    )
    val mockIcon = painterResource(R.drawable.place)
    val mockDescription = "Описание"
    val mockActions = @Composable {
        Row {
            ActionButton(
                modifier = Modifier.padding(end = 4.dp).size(40.dp),
                onClick = { },
                colors = mockColors,
                iconPainter = mockIcon,
                iconDescription = mockDescription,
            )
            ActionButton(
                modifier = Modifier.padding(start = 4.dp).size(40.dp),
                onClick = { },
                colors = mockColors,
                iconPainter = mockIcon,
                iconDescription = mockDescription,
            )
        }
    }
    FieldWithIcon(
        modifier = Modifier.width(600.dp),
        text = "ул. Покрышкина, дом 92",
        onClick = {},
        actions = mockActions,
    )
}