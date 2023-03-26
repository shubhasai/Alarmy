package com.shubhasai.alarmy

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shubhasai.alarmy.data.AdvanceSetting
import com.shubhasai.alarmy.data.AlarmDetails
import com.shubhasai.alarmy.screens.Screen
import com.shubhasai.alarmy.ui.theme.AlarmyTheme
import com.shubhasai.alarmy.data.AlarmParameters
import com.shubhasai.alarmy.ui.theme.components.TimePicker

@Composable
fun Alarm_MainScreen(navController: NavController){
    val TagData = arrayOf("Water","Medicine","Walk")
    val LabelData = arrayOf("Power Nap","Blood Pressure","Afternoon")
    val VibrationData = arrayOf("Pattern 1","Pattern 2","Pattern 3")
    val SoundData = arrayOf("Spring","Smooth Bell","Summer Rain")
    var StatusswitchState by remember { mutableStateOf(false) }
    val options = arrayOf("Option 1", "Option 2", "Option 3")
    var selectedOption by remember { mutableStateOf("") }
    var Status by remember {
        mutableStateOf(AlarmDetails.Status)
    }
    var Tag by remember {
        mutableStateOf(AlarmDetails.Tag)
    }
    var Label by remember {
        mutableStateOf(AlarmDetails.Label)
    }
    var Description by remember{
        mutableStateOf(AlarmDetails.Description)
    }
    var Remindermode by remember {
        mutableStateOf(AlarmDetails.Remindermode)
    }
    var VibrationStatus by remember{
        mutableStateOf(AlarmDetails.VibrationStatus)
    }
    var VibrationPatter by remember {
        mutableStateOf(AlarmDetails.VibrationPatter)
    }
    var SoundStatus by remember{
        mutableStateOf(AlarmDetails.SoundStatus)
    }
    var SoundPattern by remember {
        mutableStateOf(AlarmDetails.SoundPattern)
    }
    var Important by remember{
        mutableStateOf(false)
    }
    var tagclicked by remember {
        mutableStateOf(false)
    }
    var labelclicked by remember{
        mutableStateOf(false)
    }
    var descriptionClicked by remember {
        mutableStateOf(false)
    }
    var vibrationclicked by remember {
        mutableStateOf(false)
    }
    var soundpatternclicked by remember {
        mutableStateOf(false)
    }
    AlarmDetails.Status = Status
    AlarmDetails.Tag = Tag
    AlarmDetails.Label = Label
    AlarmDetails.Description = Description
    AlarmDetails.Remindermode = Remindermode
    AlarmDetails.VibrationStatus = VibrationStatus
    AlarmDetails.VibrationPatter = VibrationPatter
    AlarmDetails.SoundStatus = SoundStatus
    AlarmDetails.SoundPattern = SoundPattern
    AlarmDetails.Important = Important
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        MyAppBar(title = "Alarm Setting")
        Spacer(modifier = Modifier.padding(10.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Settime()
            // Status
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
                    text = "Status",
                    modifier = Modifier.weight(1f)
                )

                Switch(
                    checked = Status,
                    onCheckedChange = { Status = it },
                )
            }
            //Tag
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_status),
                    contentDescription = "Icon",
                    tint= Color.Unspecified
                )
                Text(
                    text = "Tag",
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = Tag,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.End)
                )
                IconButton(
                    onClick = {
                              tagclicked=!tagclicked
                    },
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_options),
                        tint= Color.Unspecified,
                        contentDescription = "Right arrow icon"
                    )
                }
                if(tagclicked){
                    DropdownList(options = TagData, onOptionSelected = {
                        Tag = it
                    } )
                }
            }
            //Label
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_label),
                    contentDescription = "Icon",
                    tint= Color.Unspecified
                )
                Text(
                    text = "Label",
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = Label,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.End)
                )
                IconButton(
                    onClick = { labelclicked =!labelclicked},
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_options),
                        tint= Color.Unspecified,
                        contentDescription = "Right arrow icon"
                    )
                }
                if(labelclicked){
                    DropdownList(options = LabelData, onOptionSelected = {
                        Label = it
                    } )
                }
            }
            // Description
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_description),
                    contentDescription = "Icon",
                    tint= Color.Unspecified
                )
                Text(
                    text = "Description",
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = Description,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.End)
                )
                IconButton(
                    onClick = { descriptionClicked = !descriptionClicked},
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_options),
                        tint= Color.Unspecified,
                        contentDescription = "Right arrow icon"
                    )
                }
                if(tagclicked){

                }
            }
            //Interval and Setting
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_access_alarms_24),
                    contentDescription = "Icon",
                    tint= Color.Unspecified
                )
                Text(
                    text = "Interval and Setting",
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = Label,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.End)
                )
                IconButton(
                    onClick = {
                        navController.navigate(Screen.SettingScreen.route)
                    },
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
                    text = "Reminder Mode",
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Notification",
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
                    painter = painterResource(R.drawable.ic_vibration),
                    contentDescription = "Icon",
                    tint= Color.Unspecified
                )
                Text(
                    text = "Vibration",
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            vibrationclicked = !vibrationclicked
                        })
                Text(
                    text = VibrationPatter,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.End)
                        .clickable {
                            vibrationclicked = !vibrationclicked
                        }
                )
                Switch(
                    checked = VibrationStatus,
                    onCheckedChange = { VibrationStatus = it},
                )
                if(vibrationclicked){
                    DropdownList(options = VibrationData, onOptionSelected = {
                        VibrationPatter = it
                    } )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_sound),
                    contentDescription = "Icon",
                    tint= Color.Unspecified
                )
                Text(
                    text = "Sound",
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    text = SoundPattern,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.End)
                        .clickable {
                            soundpatternclicked = !soundpatternclicked
                        }
                )
                Switch(
                    checked = SoundStatus,
                    onCheckedChange = { SoundStatus = it },
                )
                if(soundpatternclicked){
                    DropdownList(options = SoundData, onOptionSelected = {
                        SoundPattern = it
                    } )
                }
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
                    text = "Important",
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = Important,
                    onCheckedChange = { Important = it},
                )
            }
            // Add more settings here
        }
        }

}

@Composable
fun Settime(){
    TimePicker()
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropdownList(options: Array<String>, onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            readOnly = false,
            value = selectedOptionText,
            onValueChange = {selectedOptionText = it
                onOptionSelected(it)},
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        onOptionSelected(selectionOption)
                        expanded = false
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }
    }
}

@Composable
fun InputDialog(){

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlarmyTheme {

    }
}