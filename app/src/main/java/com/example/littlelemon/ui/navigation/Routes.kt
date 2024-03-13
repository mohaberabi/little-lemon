package com.example.littlelemon.ui.navigation


abstract class RoutesString {

    companion object {


        const val home = "home"
        const val onBoarding = "onBoarding"
        const val profile = "profile"

    }

}

interface Routes {
    val route: String
}


object OnBoardingRoute : Routes {
    override val route: String
        get() = RoutesString.onBoarding

}

object HomeRoute : Routes {
    override val route: String
        get() = RoutesString.home

}

object ProfileRoute : Routes {
    override val route: String
        get() = RoutesString.profile

}