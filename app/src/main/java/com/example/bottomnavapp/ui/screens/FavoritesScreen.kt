package com.example.bottomnavapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavapp.ui.theme.BottomNavAppTheme

@Composable
fun FavoritesScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta), // Distinct background color
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Favorites Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    BottomNavAppTheme {
        FavoritesScreen(rememberNavController())
    }
}
