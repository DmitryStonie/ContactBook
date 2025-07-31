package com.dmitrystonie.contactbook.contactinfo.presentation

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

class LocationLooker(private val context: Context) {
    fun showLocation(latitude: String, longitude: String) {
        val geoLocation = ("geo:$latitude,$longitude").toUri()
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = geoLocation
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }
}