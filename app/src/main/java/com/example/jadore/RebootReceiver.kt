package com.example.jadore

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class RebootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
           SetTheAlarm.run(context)
        }
    }
}