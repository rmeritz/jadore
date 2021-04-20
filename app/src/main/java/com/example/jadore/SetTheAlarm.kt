package com.example.jadore

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.*

class SetTheAlarm {
    companion object {
        fun run(context: Context) {

            val calendar: Calendar = Calendar.getInstance().apply {
                timeInMillis = System.currentTimeMillis()

                // TODO: Change time time we want message to send
                set(Calendar.HOUR_OF_DAY, 2)
                set(Calendar.MINUTE, 9)
                set(Calendar.DAY_OF_MONTH, 20)
                val tz = TimeZone.getTimeZone("UTC")
                timeZone = tz
            }

            val alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(context, AlarmReceiver::class.java)
            var alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0)
            // NB: Can be used for debugging to send immediate message
            // alarmMgr.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + 5000, alarmIntent)

            alarmMgr.setInexactRepeating(
                AlarmManager.RTC,
                calendar.timeInMillis,
                AlarmManager.INTERVAL_FIFTEEN_MINUTES,
                // TODO: Switch back to day interval
                //AlarmManager.INTERVAL_DAY,
                alarmIntent)
        }
    }
}
