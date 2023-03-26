package com.shubhasai.alarmy

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shubhasai.alarmy.data.AdvanceSetting
import com.shubhasai.alarmy.data.AlarmDetails
import com.shubhasai.alarmy.data.AlarmParameters
import com.shubhasai.alarmy.screens.Screen
import java.util.*

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.AlamSetting.route ){
        composable(route = Screen.AlamSetting.route){
            Alarm_MainScreen(navController)
        }
        composable(route = Screen.SettingScreen.route){
            SettingScreen()
        }
    }
}


@Composable
fun MyAppBar(title: String) {
    var save by remember{
        mutableStateOf(false)
    }
    val crossIcon = painterResource(id = R.drawable.ic_save)
    val ticIcon = painterResource(id = R.drawable.ic_wrong)
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            IconButton(onClick = { save = !save}) {
                Icon(painter = crossIcon, contentDescription = "Cross")
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(painter = ticIcon, contentDescription = "Tic")
            }
        }
    )
    if (save){
        val context = LocalContext.current
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)

        val calendar: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, AlarmDetails.hr.toInt())
            set(Calendar.MINUTE, AlarmDetails.min.toInt())
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)

        }
        Log.d("Check Time", calendar.timeInMillis.toString())
// Repeat every 24 hours
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )

// Schedule the alarm
//        if(AlarmDetails.Status){
//            val alarmTime = calendar.timeInMillis
//            Log.d("Alarm", "Setting alarm for: ${alarmTime}")
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                Log.d("Alarm", "Setting alarm for: ${alarmTime}")
//                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent)
//            } else {
//                Log.d("Alarm", "Setting alarm for2: ${alarmTime}")
//                alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent)
//            }
//        }

        val nextAlarm = alarmManager.nextAlarmClock
        if (nextAlarm != null) {
            // An alarm is scheduled to go off at the specified time
            val triggerTime = nextAlarm.triggerTime
            // Use the triggerTime to display or log the next alarm time
            Log.d("Alarm", "Next alarm at: ${triggerTime}")
        } else {
            // No alarm is currently scheduled
            Log.d("Alarm", "No alarm scheduled")
        }
    }
}