package com.example.bottomnavapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bottomnavapp.ui.theme.BottomNavAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavAppTheme {
                MainAppScreen() // Use the new MainAppScreen composable
            }
        }
    }
}
