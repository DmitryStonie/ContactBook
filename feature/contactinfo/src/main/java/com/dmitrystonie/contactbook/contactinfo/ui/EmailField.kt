package com.dmitrystonie.contactbook.contactinfo.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.contactbook.component.theme.ButtonContent
import com.dmitrystonie.contactbook.component.theme.EmailActionColor
import com.dmitrystonie.contactbook.feature.contactinfo.R
import com.dmitrystonie.contactbook.ui.ActionButton
import com.dmitrystonie.contactbook.ui.FieldWithIcon

@Composable
fun EmailField(email: String, onEmailClick: (String) -> Unit) {
    val emailActionColors = ButtonColors(
        containerColor = EmailActionColor,
        contentColor = ButtonContent,
        disabledContainerColor = EmailActionColor,
        disabledContentColor = ButtonContent
    )
    val actions = @Composable {
        ActionButton(
            modifier = Modifier.size(40.dp),
            onClick = { onEmailClick(email) },
            colors = emailActionColors,
            iconPainter = painterResource(R.drawable.email_icon),
            iconDescription = stringResource(R.string.email_action_description),
        )
    }
    FieldWithIcon(
        modifier = Modifier.fillMaxWidth(), text = email, onClick = {}, actions = actions
    )
}

@Preview
@Composable
fun EmailFieldPreview() {
    EmailField(
        email = "alexander.rasmussen@example.com",
        onEmailClick = {},
    )
}