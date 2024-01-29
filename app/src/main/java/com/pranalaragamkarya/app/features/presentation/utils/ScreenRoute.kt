package com.pranalaragamkarya.app.features.presentation.utils

sealed class ScreenRoute(val route:String) {
    object Landing:ScreenRoute("landing")
    object Home:ScreenRoute("home")
}
