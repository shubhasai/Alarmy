package com.shubhasai.alarmy

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings
import android.util.Log
import android.widget.Toast

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "MyBroadcastReceiverAction") {
            Log.d("ALARM", "RECEIVED")
            val mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI)
            mediaPlayer.start()
        }
    }
}

