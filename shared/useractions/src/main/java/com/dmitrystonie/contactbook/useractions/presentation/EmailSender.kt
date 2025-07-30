package com.dmitrystonie.contactbook.contactinfo.presentation

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri


class EmailSender(private val context: Context){
    fun sendEmail(addresses: Array<String>) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = "mailto:".toUri()
            putExtra(Intent.EXTRA_EMAIL, addresses)
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }
}