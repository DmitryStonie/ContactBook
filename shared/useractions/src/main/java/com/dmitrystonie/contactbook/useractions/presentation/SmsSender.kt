package com.dmitrystonie.contactbook.contactinfo.presentation

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

class SmsSender(private val context: Context) {
    fun composeSmsMessage(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = "smsto:$phoneNumber".toUri()
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }
}