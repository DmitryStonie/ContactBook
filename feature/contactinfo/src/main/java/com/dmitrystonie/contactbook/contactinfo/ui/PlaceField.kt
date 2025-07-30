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
import com.dmitrystonie.contactbook.component.theme.BgPrimary
import com.dmitrystonie.contactbook.component.theme.PlaceActionColor
import com.dmitrystonie.contactbook.contact.domain.Coordinates
import com.dmitrystonie.contactbook.feature.contactinfo.R
import com.dmitrystonie.contactbook.ui.ActionButton
import com.dmitrystonie.contactbook.ui.FieldWithIcon

@Composable
fun PlaceField(place: String, coordinates: Coordinates, onLocationClick: (latitude: String, longitude: String) -> Unit) {
    val placeActionColors = ButtonColors(
        containerColor = PlaceActionColor,
        contentColor = BgPrimary,
        disabledContainerColor = PlaceActionColor,
        disabledContentColor = BgPrimary
    )
    val actions = @Composable {
        ActionButton(
            modifier = Modifier.size(40.dp),
            onClick = {onLocationClick(coordinates.latitude, coordinates.longitude)},
            colors = placeActionColors,
            iconPainter = painterResource(R.drawable.place_icon),
            iconDescription = stringResource(R.string.place_action_description),
        )
    }
    FieldWithIcon(
        modifier = Modifier.fillMaxWidth(), text = place, onClick = {}, actions = actions
    )
}

@Preview
@Composable
fun PlaceFieldPreview() {
    PlaceField(
        place = "1173, Højstrupvej",
        coordinates = Coordinates("12.234214", "74.913292"),
        onLocationClick = { _,_ -> },
    )
}