package com.example.tugasfrontend

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Settings: Screen("settings")
    object Profile: Screen("profile")
}