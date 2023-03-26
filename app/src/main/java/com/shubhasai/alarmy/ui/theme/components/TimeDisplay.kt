package com.shubhasai.alarmy.ui.theme.components

import android.provider.SyncStateContract.Columns
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubhasai.alarmy.Settime

@Composable
fun TimeDisplay (selected_Time:String): MutableState<Boolean> {
    var clicked = remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .size(30.dp,30.dp)
        .padding(2.dp)
        .clickable {
                  clicked.value = true
            Log.d("Called","ClickedCard"+ clicked.value.toString())
        },
        elevation = 5.dp,
        backgroundColor = Color.DarkGray) {
        Text(text = selected_Time,
            modifier = Modifier,
            fontSize = 20.sp)
    }
    return clicked
}

