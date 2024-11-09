package com.jubayer_ahamad_tayef.sukhi_bazar.ui.theme // Package for theme-related definitions

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jubayer_ahamad_tayef.sukhi_bazar.R

// Define the Poppins font family with different weights
val PoppinsFontFamily = FontFamily(
    Font(R.font.poppins_black, FontWeight.Black),
    Font(R.font.poppins_extra_bold, FontWeight.ExtraBold),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_extra_light, FontWeight.ExtraLight),
    Font(R.font.poppins_thin, FontWeight.Thin)
)

// Define the typography styles using the Poppins font family
val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Bold, fontSize = 40.sp
    ), displayMedium = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Bold, fontSize = 34.sp
    ), displaySmall = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Medium, fontSize = 30.sp
    ), headlineLarge = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Bold, fontSize = 24.sp
    ), headlineMedium = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Medium, fontSize = 20.sp
    ), headlineSmall = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Medium, fontSize = 18.sp
    ), titleLarge = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Bold, fontSize = 20.sp
    ), titleMedium = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Medium, fontSize = 18.sp
    ), titleSmall = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Medium, fontSize = 16.sp
    ), bodyLarge = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp
    ), bodyMedium = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp
    ), bodySmall = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp
    ), labelLarge = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Medium, fontSize = 14.sp
    ), labelMedium = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Medium, fontSize = 12.sp
    ), labelSmall = TextStyle(
        fontFamily = PoppinsFontFamily, fontWeight = FontWeight.Medium, fontSize = 10.sp
    )
)