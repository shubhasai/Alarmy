package com.shubhasai.alarmy

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shubhasai.alarmy.data.AlarmDetails

@Composable
fun SettingScreen(){
    var Snooze by remember {
        mutableStateOf(AlarmDetails.Snooze)
    }
    var AdvanceReminder by remember {
        mutableStateOf(AlarmDetails.AdvanceReminder)
    }
    var AdvanceReminderTime by remember {
        mutableStateOf(AlarmDetails.AdvanceReminderTime)
    }
    var Duration by remember {
        mutableStateOf(AlarmDetails.Duration)
    }
    var ReminderatEnd by remember {
        mutableStateOf(AlarmDetails.ReminderatEnd)
    }
    var IntervalStatus by remember {
        mutableStateOf(AlarmDetails.IntervalStatus)
    }
    AlarmDetails.Snooze = Snooze
    AlarmDetails.AdvanceReminder = AdvanceReminder
    AlarmDetails.AdvanceReminderTime = AdvanceReminderTime
    AlarmDetails.Duration = Duration
    AlarmDetails.ReminderatEnd = ReminderatEnd
    AlarmDetails.IntervalStatus = IntervalStatus
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MyAppBar(title = "Time Setting")
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_alarms_status),
                    contentDescription = "Icon",
                    tint= Color.Unspecified
                )
                Text(
                    text = "Snooze",
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "$Snooze Minutes",
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.End)
                )
                IconButton(
                    onClick = { /* Do something */ },
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_options),
                        tint= Color.Unspecified,
                        contentDescription = "Right arrow icon"
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_reminder),
                    contentDescription = "Icon",
                    tint= Color.Unspecified
                )
                Text(
                    text = "Advance Reminder",
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "$AdvanceReminderTime Mins",
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.End)
                )
                Switch(
                    checked = AdvanceReminder,
                    onCheckedChange = { AdvanceReminder = it },
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_timer),
                    contentDescription = "Icon",
                    tint= Color.Unspecified
                )
                Text(
                    text = "Duration",
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "$Duration Minutes",
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.End)
                )
                IconButton(
                    onClick = { /* Do something */ },
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_options),
                        tint= Color.Unspecified,
                        contentDescription = "Right arrow icon"
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_reminder),
                    contentDescription = "Icon",
                    tint= Color.Unspecified
                )
                Text(
                    text = "Reminder at the end of duration",
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = ReminderatEnd,
                    onCheckedChange = { ReminderatEnd = it },
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_important),
                    contentDescription = "Icon",
                    tint= Color.Unspecified
                )
                Text(
                    text = "Interval's Status",
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = IntervalStatus,
                    onCheckedChange = { IntervalStatus = it },
                )
            }
        }
    }
}