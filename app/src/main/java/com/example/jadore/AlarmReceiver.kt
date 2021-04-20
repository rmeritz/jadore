package com.example.jadore

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val smsManager = SmsManager.getDefault()
        val intent = Intent(context, LoggingReceiver::class.java)
        val loggingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)
        // TODO: Hookup with LoveMessage to send a random message
        // TODO: Change Number
        smsManager.sendTextMessage("+12675593133", null, "KISSES", loggingIntent, loggingIntent)
    }
}

class LoggingReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("AlarmReciver", "Something happened")
    }
}