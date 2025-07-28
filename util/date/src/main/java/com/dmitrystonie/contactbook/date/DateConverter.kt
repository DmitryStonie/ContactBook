package com.dmitrystonie.contactbook.date

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.toBirthDate(): String{
    val dtStart = "2010-10-15T09:27:37Z"
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
    val resultFormat = SimpleDateFormat("dd.MM.yyyy", Locale.US)
    try {
        val date: Date = format.parse(dtStart) ?: return ""
        return resultFormat.format(date).toString()
    } catch (e: ParseException) {
        e.printStackTrace()
        return ""
    }
}