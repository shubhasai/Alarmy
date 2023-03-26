package com.shubhasai.alarmy.data

data class AlarmParameters(
    var hr:Int = -1,
    var min:Int = -1,
    var Status:Boolean = false,
    var Tag:String = "Water",
    var Label:String = "Power Nap",
    var Description:String = "Relax to Energise",
    var SettingData:AdvanceSetting = AdvanceSetting(),
    var Remindermode:String = "Notification",
    var VibrationStatus:Boolean = false,
    var VibrationPatter:String = "Pattern1",
    var SoundStatus:Boolean = false,
    var SoundPattern:String = "Spring",
    var Important:Boolean = false
)

data class AdvanceSetting(
    var Snooze:Int = 5,
    var AdvanceReminder:Boolean = false,
    var Duration:Int = 30,
    var ReminderatEnd:Boolean = true,
    var IntervalStatus:Boolean = true
) {

}
