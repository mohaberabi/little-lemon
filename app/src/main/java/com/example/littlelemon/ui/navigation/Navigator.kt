package com.example.littlelemon.ui.navigation

import android.content.SharedPreferences
import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.MainActivity
import com.example.littlelemon.const.AppPrefsKeys
import com.example.littlelemon.data.MenuItemEntity
import com.example.littlelemon.network.MenuItemNetwork
import com.example.littlelemon.ui.screens.HomeScreen
import com.example.littlelemon.ui.screens.OnBoardingScreen
import com.example.littlelemon.ui.screens.ProfileScreen


@Composable

fun Navigator(prefs: SharedPreferences, items: List<MenuItemEntity>) {

    val navController = rememberNavController()


    val key: String? = prefs.getString(AppPrefsKeys.email, null)


    val startDestination = if (key == null) OnBoardingRoute.route else HomeRoute.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(OnBoardingRoute.route) {
            OnBoardingScreen(
                prefs = prefs,
                navController = navController,
            )
        }
        composable(HomeRoute.route) {

            HomeScreen(
                navController = navController,
                items = items.sortedBy { it.title }
            )
        }
        composable(ProfileRoute.route) {

            ProfileScreen(
                prefs = prefs,
                navController = navController
            )
        }
    }

}