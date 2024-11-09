package com.jubayer_ahamad_tayef.sukhi_bazar.ui.theme // Package for theme-related definitions

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Define the dark color scheme for the theme
private val DarkColorScheme = darkColorScheme(
    primary = Blue, secondary = PurpleGrey80, tertiary = Pink80
)

// Define the light color scheme for the theme
private val LightColorScheme = lightColorScheme(
    primary = Blue, secondary = PurpleGrey40, tertiary = Pink40
)

// Composable function to set the theme for the app
@Composable
fun Sukhi_Bazar_Theme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Use system's dark theme setting by default
    dynamicColor: Boolean = true, // Dynamic color is available on Android 12+
    content: @Composable () -> Unit // Lambda to specify the content within the theme
) {
    // Determine the color scheme based on dynamic color and dark theme settings
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // Apply the theme with the determined color scheme and typography
    MaterialTheme(
        colorScheme = colorScheme, typography = AppTypography, content = content
    )
}