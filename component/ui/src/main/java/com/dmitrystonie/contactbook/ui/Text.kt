package com.dmitrystonie.contactbook.component.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dmitrystonie.contactbook.component.theme.TextPrimary
import com.dmitrystonie.contactbook.component.theme.TextSecondary

val titleStyle = TextStyle(
    fontSize = 20.sp,
    fontWeight = FontWeight.W500,
    letterSpacing = 0.sp,
)

val textStyle = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight.W400,
    letterSpacing = 0.sp,
)

@Composable
fun Title(modifier: Modifier = Modifier, text: String, color: Color){
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = titleStyle
    )
}

@Composable
fun Text(modifier: Modifier = Modifier, text: String, color: Color){
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = textStyle
    )
}

@Composable
@Preview
fun TitlePreview(){
    Title(
        text = "Иванов Иван Иванович",
        color = TextPrimary
    )
}

@Composable
@Preview
fun TextPreview(){
    Text(
        text = "Ленина 22, кв 91",
        color = TextSecondary
    )
}