package com.example.bottomnavapp

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavapp.ui.theme.BottomNavAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") // Will be handled by NavHost
@Composable
fun MainAppScreen() {
    val navController = rememberNavController()
    val currentScreen = currentScreenAsState(navController)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentScreen.value) } // Display current screen title
            )
        },
        bottomBar = {
            // The BottomNavigation composable will be created in the next step
            // For now, we pass the navController and a list of items
            AppBottomNavigation(
                navController = navController,
                items = listOf(
                    Screen.Home,
                    Screen.Favorites,
                    Screen.Main,
                    Screen.Settings,
                    Screen.Profile
                )
            )
        }
    ) {
        // Content area - AppNavigation hosts the different screens
        AppNavigation(navController = navController)
    }
}

@Composable
fun currentScreenAsState(navController: NavHostController): androidx.compose.runtime.State<String> {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return androidx.compose.runtime.derivedStateOf {
        // Find the Screen object that matches the current route
        val currentRoute = navBackStackEntry?.destination?.route
        listOf(Screen.Home, Screen.Favorites, Screen.Main, Screen.Settings, Screen.Profile)
            .find { it.route == currentRoute }?.title ?: "App" // Default title
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BottomNavAppTheme {
        MainAppScreen()
    }
}
