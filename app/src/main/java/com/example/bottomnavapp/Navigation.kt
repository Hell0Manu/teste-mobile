package com.example.bottomnavapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavapp.ui.screens.HomeScreen
import com.example.bottomnavapp.ui.screens.FavoritesScreen
import com.example.bottomnavapp.ui.screens.MainScreenPlaceholder // This will be the screen for the principal button
import com.example.bottomnavapp.ui.screens.SettingsScreen
import com.example.bottomnavapp.ui.screens.ProfileScreen

// Sealed class to define navigation routes
sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Home")
    object Favorites : Screen("favorites", "Favorites")
    object Main : Screen("main", "Main") // Principal item
    object Settings : Screen("settings", "Settings")
    object Profile : Screen("profile", "Profile")
}

// Composable to set up the NavHost and NavController
@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Favorites.route) { FavoritesScreen(navController) }
        composable(Screen.Main.route) { MainScreenPlaceholder(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
    }
}
