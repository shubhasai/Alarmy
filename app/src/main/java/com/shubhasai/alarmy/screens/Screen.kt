package com.shubhasai.alarmy.screens

sealed class Screen( val route:String){
    object AlamSetting: Screen("alarm_setting")
    object SettingScreen: Screen("setting_screen")
}
