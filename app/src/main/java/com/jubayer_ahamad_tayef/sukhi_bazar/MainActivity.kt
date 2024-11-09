package com.jubayer_ahamad_tayef.sukhi_bazar // Defines the package for the main application component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jubayer_ahamad_tayef.sukhi_bazar.ui.feature.home.HomeScreen
import com.jubayer_ahamad_tayef.sukhi_bazar.ui.theme.Sukhi_Bazar_Theme

// MainActivity class which acts as the entry point of the application
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge mode for a more immersive experience
        enableEdgeToEdge()

        // Set the content of the activity to be the Compose UI
        setContent {
            // Apply the app's theme
            Sukhi_Bazar_Theme {
                // Create a navigation controller to manage navigation between screens
                val navController = rememberNavController()

                // Set up the navigation host with the start destination as "home"
                NavHost(navController = navController, startDestination = "home") {
                    // Define a composable destination for the home screen
                    composable("home") { HomeScreen(navController = navController) }
                }
            }
        }
    }
}