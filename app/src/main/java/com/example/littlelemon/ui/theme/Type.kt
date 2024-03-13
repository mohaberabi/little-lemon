package com.example.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R


private val primaryFont = FontFamily(
    Font(R.font.karla)
)

val primaryStyle = TextStyle(
    fontFamily = primaryFont,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp,
    color = Color.Black
)

val Typography = Typography(
    bodyLarge = primaryStyle,
    bodySmall = primaryStyle.copy(
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        lineHeight = 18.sp
    ),

    headlineLarge = primaryStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    headlineMedium = primaryStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),

    displayLarge = primaryStyle.copy(
        fontSize = 34.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight.Bold
    ),
    displayMedium = primaryStyle.copy(
        fontSize = 28.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    displaySmall = primaryStyle.copy(fontSize = 24.sp, lineHeight = 20.sp),

    labelLarge = primaryStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )
)