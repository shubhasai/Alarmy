package com.shubhasai.alarmy.ui.theme.components

import android.app.TimePickerDialog
import android.util.Log
import android.widget.TimePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubhasai.alarmy.data.AlarmDetails
import com.shubhasai.alarmy.ui.theme.Blue088
import java.util.*

@Composable
fun TimePicker(){
    val mContext = LocalContext.current

    // Declaring and initializing a calendar
    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]

    // Value for storing time as a string
    val mTime = remember { mutableStateOf("12:00") }

    // Creating a TimePicker dialod
    val mTimePickerDialog = TimePickerDialog(
        mContext,
        {_, mHour : Int, mMinute: Int ->
            mTime.value = "$mHour:$mMinute"
            AlarmDetails.hr = mHour
            AlarmDetails.min = mMinute
        }, mHour, mMinute, true
    )

    Row(
        modifier = Modifier
            .clickable {
                mTimePickerDialog.show()
            }
            .wrapContentHeight()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {mTimePickerDialog.show()},
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue088),
            modifier = Modifier.wrapContentHeight()
                .fillMaxWidth()
        ) {
            Text(text = mTime.value, color = Color.White,fontSize = 36.sp)
        }
    }
}
