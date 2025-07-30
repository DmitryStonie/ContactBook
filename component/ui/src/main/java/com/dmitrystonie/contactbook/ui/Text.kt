package com.dmitrystonie.contactbook.component.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

val bigTitleStyle = TextStyle(
    fontSize = 28.sp,
    fontWeight = FontWeight.W400,
    letterSpacing = 0.sp,
)

val titleStyle = TextStyle(
    fontSize = 20.sp,
    fontWeight = FontWeight.W400,
    letterSpacing = 0.sp,
)

val textStyle = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight.W400,
    letterSpacing = 0.sp,
)

val smallTextStyle = TextStyle(
    fontSize = 14.sp,
    fontWeight = FontWeight.W400,
    letterSpacing = 0.sp,
)

@Composable
fun BigTitle(modifier: Modifier = Modifier, text: String, color: Color, maxLines: Int = 1){
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = bigTitleStyle,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
    )
}

@Composable
fun Title(modifier: Modifier = Modifier, text: String, color: Color, maxLines: Int = 1){
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = titleStyle,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
    )
}

@Composable
fun Text(modifier: Modifier = Modifier, text: String, color: Color, maxLines: Int = 1){
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = textStyle,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
    )
}

@Composable
fun SmallText(modifier: Modifier = Modifier, text: String, color: Color, maxLines: Int = 1){
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = smallTextStyle,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
    )
}

@Composable
@Preview
fun BigTitlePreview(){
    BigTitle(
        text = "Иванов Иван Иванович",
        color = MaterialTheme.colorScheme.onSurface
    )
}

@Composable
@Preview
fun TitlePreview(){
    Title(
        text = "Иванов Иван Иванович",
        color = MaterialTheme.colorScheme.onSurface
    )
}

@Composable
@Preview
fun TextPreview(){
    Text(
        text = "Ленина 22, кв 91",
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}