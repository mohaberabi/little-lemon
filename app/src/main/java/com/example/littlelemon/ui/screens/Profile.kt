package com.example.littlelemon.ui.screens

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.littlelemon.const.AppPrefsKeys
import com.example.littlelemon.ui.composables.AppLogo
import com.example.littlelemon.ui.composables.UserInfoCompose
import com.example.littlelemon.ui.navigation.OnBoardingRoute


@Composable

fun ProfileScreen(
    prefs: SharedPreferences,
    navController: NavController,
) {
    val name = prefs.getString(AppPrefsKeys.name, "")
    val lastName = prefs.getString(AppPrefsKeys.lastName, "")
    val email = prefs.getString(AppPrefsKeys.email, "")

    Column {
        UserInfoCompose(
            name = name!!,
            lastName = lastName!!,

            email = email!!,
            isReaOnly = true,
            buttonLabel = "Log out",
            onButtonPressed = {
                prefs.edit().clear().apply()
                navController.navigate(OnBoardingRoute.route)
            }
        )
    }

}