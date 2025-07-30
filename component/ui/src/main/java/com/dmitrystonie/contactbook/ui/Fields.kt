package com.dmitrystonie.contactbook.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.contactbook.component.theme.ButtonContent
import com.dmitrystonie.contactbook.component.theme.PlaceActionColor
import com.dmitrystonie.contactbook.component.ui.R
import com.dmitrystonie.contactbook.component.ui.SmallText
import com.dmitrystonie.contactbook.component.ui.Title

@Composable
fun FieldWithIconAndSubtitle(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    actions: @Composable (() -> Unit),
    maxLines: Int = 1,
    subtitle: String
) {
    Row(
        modifier = modifier
            .clickable(true, onClick = onClick)
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(3f)) {

            Title(
                text = text, color = MaterialTheme.colorScheme.onSurface, maxLines = maxLines
            )
            SmallText(
                modifier = Modifier.padding(top = 4.dp),
                text = subtitle,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = maxLines
            )
        }
        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.End) {
            actions()
        }
    }
}

@Composable
fun FieldWithIcon(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    actions: @Composable (() -> Unit),
    maxLines: Int = 1
) {
    Row(
        modifier = modifier
            .clickable(true, onClick = onClick)
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Title(
            modifier = Modifier.weight(3f),
            text = text,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = maxLines
        )
        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.End) {
            actions()
        }
    }
}

@Preview
@Composable
fun FieldWithIconAndSubtitlePreview() {
    val mockColors = ButtonColors(
        containerColor = PlaceActionColor,
        contentColor = ButtonContent,
        disabledContainerColor = PlaceActionColor,
        disabledContentColor = ButtonContent
    )
    val mockIcon = painterResource(R.drawable.place)
    val mockDescription = "Описание"
    val mockActions = @Composable {
        Row {
            ActionButton(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(40.dp),
                onClick = { },
                colors = mockColors,
                iconPainter = mockIcon,
                iconDescription = mockDescription,
            )
            ActionButton(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(40.dp),
                onClick = { },
                colors = mockColors,
                iconPainter = mockIcon,
                iconDescription = mockDescription,
            )
        }
    }
    FieldWithIconAndSubtitle(
        modifier = Modifier.width(600.dp),
        text = "ул. Покрышкина, дом 92sdfasdf",
        onClick = {},
        actions = mockActions,
        subtitle = "Адрес"
    )
}


@Preview
@Composable
fun FieldWithIconPreview() {
    val mockColors = ButtonColors(
        containerColor = PlaceActionColor,
        contentColor = ButtonContent,
        disabledContainerColor = PlaceActionColor,
        disabledContentColor = ButtonContent
    )
    val mockIcon = painterResource(R.drawable.place)
    val mockDescription = "Описание"
    val mockActions = @Composable {
        Row {
            ActionButton(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(40.dp),
                onClick = { },
                colors = mockColors,
                iconPainter = mockIcon,
                iconDescription = mockDescription,
            )
            ActionButton(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(40.dp),
                onClick = { },
                colors = mockColors,
                iconPainter = mockIcon,
                iconDescription = mockDescription,
            )
        }
    }
    FieldWithIcon(
        modifier = Modifier.width(600.dp),
        text = "ул. Покрышкина, дом 92sdfasdf",
        onClick = {},
        actions = mockActions,
    )
}