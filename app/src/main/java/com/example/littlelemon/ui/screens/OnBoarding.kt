package com.example.littlelemon.ui.screens

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.littlelemon.const.AppPrefsKeys
import com.example.littlelemon.ui.composables.UserInfoCompose
import com.example.littlelemon.ui.navigation.HomeRoute


@Composable

fun OnBoardingScreen() {
    UserInfoCompose()
}

@Composable

fun OnBoardingScreen(
    prefs: SharedPreferences,
    navController: NavController,
) {
    val name = remember {

        mutableStateOf("")
    }
    val lastName = remember {

        mutableStateOf("")
    }

    val email = remember {
        mutableStateOf("")
    }
    val enabled = email.value.isNotEmpty()
            && name.value.isNotEmpty()
            && lastName.value.isNotEmpty()
    UserInfoCompose(
        enabled = enabled,
        email = email.value,
        name = name.value,
        lastName = lastName.value,
        buttonLabel = "Register",
        onEmailChanged = {
            email.value = it
        },

        onNameChanged = {
            name.value = it
        },
        onLastNameChanged = {
            lastName.value = it
        },
        onButtonPressed = {
            register(
                name = name.value,
                lastName = lastName.value,
                email = email.value,
                prefs = prefs
            )

            navController.navigate(HomeRoute.route)
        }
    )
}

private fun register(
    name: String,
    lastName: String,
    email: String,
    prefs: SharedPreferences
) {
    prefs.edit().putString(AppPrefsKeys.email, email).apply()
    prefs.edit().putString(AppPrefsKeys.name, name).apply()
    prefs.edit().putString(AppPrefsKeys.lastName, lastName).apply()
}

@Preview(showBackground = true)

@Composable
private fun OnBoardingPreview() {
    OnBoardingScreen()
}