package com.dmitrystonie.contactbook.contactinfo.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.contactbook.component.theme.ButtonContent
import com.dmitrystonie.contactbook.component.theme.PhoneActionColor
import com.dmitrystonie.contactbook.component.theme.SmsActionColor
import com.dmitrystonie.contactbook.feature.contactinfo.R
import com.dmitrystonie.contactbook.ui.ActionButton
import com.dmitrystonie.contactbook.ui.FieldWithIcon

@Composable
fun PhoneField(
    phone: String, onPhoneClick: (phone: String) -> Unit,
    onSmsClick: (sms: String) -> Unit,
) {
    val phoneActionColors = ButtonColors(
        containerColor = PhoneActionColor,
        contentColor = ButtonContent,
        disabledContainerColor = PhoneActionColor,
        disabledContentColor = ButtonContent
    )
    val smsActionColors = ButtonColors(
        containerColor = SmsActionColor,
        contentColor = ButtonContent,
        disabledContainerColor = SmsActionColor,
        disabledContentColor = ButtonContent
    )
    val actions = @Composable {
        Row {
            ActionButton(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(40.dp),
                onClick = {onPhoneClick(phone)},
                colors = phoneActionColors,
                iconPainter = painterResource(R.drawable.phone_icon),
                iconDescription = stringResource(R.string.phone_action_description),
            )
            ActionButton(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(40.dp),
                onClick = {onSmsClick(phone)},
                colors = smsActionColors,
                iconPainter = painterResource(R.drawable.sms_icon),
                iconDescription = stringResource(R.string.sms_action_description),
            )
        }
    }
    FieldWithIcon(
        modifier = Modifier.fillMaxWidth(),
        text = phone,
        onClick = {},
        actions = actions
    )
}

@Preview
@Composable
fun PhoneFieldPreview() {
    PhoneField(
        phone = "7 936 273 92 73",
        onPhoneClick = {},
        onSmsClick = {}
    )
}