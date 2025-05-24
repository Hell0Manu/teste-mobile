package com.example.bottomnavapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star // Using Star for the 'Main' item
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

// Helper data class for Bottom Navigation Items
data class BottomNavItem(
    val screen: Screen, // Using the Screen sealed class from Navigation.kt
    val icon: ImageVector
)

@Composable
fun AppBottomNavigation(
    navController: NavController,
    items: List<Screen> // Pass the Screen objects directly
) {
    val navItems = items.map { screen ->
        BottomNavItem(
            screen = screen,
            icon = when (screen) {
                Screen.Home -> Icons.Filled.Home
                Screen.Favorites -> Icons.Filled.Favorite
                Screen.Main -> Icons.Filled.Star // Prominent icon for Main
                Screen.Settings -> Icons.Filled.Settings
                Screen.Profile -> Icons.Filled.Person
            }
        )
    }

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { item ->
            val isSelected = item.screen.route == currentRoute
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.screen.title
                        // Potentially make the middle icon larger or styled differently if needed
                        // For example, by using a Modifier conditionally:
                        // modifier = if (item.screen == Screen.Main) Modifier.size(36.dp) else Modifier
                    )
                },
                label = { Text(item.screen.title) },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(NavigationBarItemDefaults.IndicatorElevation)
                )
            )
        }
    }
}
