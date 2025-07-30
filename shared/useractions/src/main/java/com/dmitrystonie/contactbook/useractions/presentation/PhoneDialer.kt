package com.dmitrystonie.contactbook.contactinfo.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.net.toUri


class PhoneDialer(private val context: Context){
    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = "tel:$phoneNumber".toUri()
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }
}
