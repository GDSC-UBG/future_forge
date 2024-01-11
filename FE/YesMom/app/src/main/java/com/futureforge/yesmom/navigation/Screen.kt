package com.futureforge.yesmom.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Login : Screen("login")
    object Register : Screen("register")
    object Profile : Screen("profile")
    object FindDoctor : Screen("find_doctor")
    object Calendar : Screen("calendar")
    object DailyNotes : Screen("daily_notes")

}