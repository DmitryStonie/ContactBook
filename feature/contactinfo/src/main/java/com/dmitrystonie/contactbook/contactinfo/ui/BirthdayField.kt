package com.dmitrystonie.contactbook.contactinfo.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dmitrystonie.contactbook.feature.contactinfo.R
import com.dmitrystonie.contactbook.ui.FieldWithIconAndSubtitle


@Composable
fun BirthdayField(text: String) {
    FieldWithIconAndSubtitle(
        modifier = Modifier.fillMaxWidth(), text = text, onClick = {},
        actions = {},
        subtitle = stringResource(R.string.birthday_subtitle),
    )
}

@Preview
@Composable
fun BirthdayFieldPreview() {
    BirthdayField("12-12-2000")
}