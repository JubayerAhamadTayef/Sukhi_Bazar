package com.jubayer_ahamad_tayef.sukhi_bazar // Defines the package for the main application component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController) }) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        // Set up the navigation host with the start destination as "home"
                        NavHost(navController = navController, startDestination = "home") {
                            // Define a composable destination for the home screen
                            composable("home") { HomeScreen(navController = navController) }
                            composable("cart") {
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Text(text = "Cart")
                                }
                            }
                            composable("profile") {
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Text(text = "Profile")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun BottomNavigationBar(navController: NavController) {
        NavigationBar {
            // current route
            val currentRoute =
                navController.currentBackStackEntryAsState().value?.destination?.route
            val items = listOf(BottomNavItems.Home, BottomNavItems.Cart, BottomNavItems.Profile)
            items.forEach { item ->
                NavigationBarItem(selected = currentRoute == item.route, onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { startRoute ->
                            popUpTo(startRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }, label = { Text(text = item.title) }, icon = {
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(if (currentRoute == item.route) MaterialTheme.colorScheme.primary else Color.Gray)
                    )
                }, colors = NavigationBarItemDefaults.colors().copy(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    selectedIndicatorColor = Color.LightGray
                )
                )
            }
        }
    }
}

sealed class BottomNavItems(val route: String, val title: String, val icon: Int) {
    object Home : BottomNavItems(route = "home", title = "Home", icon = R.drawable.ic_home_icon)
    object Cart : BottomNavItems(route = "cart", title = "Cart", icon = R.drawable.ic_cart_icon)
    object Profile :
        BottomNavItems(route = "profile", title = "Profile", icon = R.drawable.ic_profile_icon)
}
