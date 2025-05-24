package com.example.bottomnavapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BottomNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testHomeScreenNavigation() {
        // Home is the start destination, so it should be displayed initially.
        composeTestRule.onNodeWithText("Home Screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Home").assertIsDisplayed() // Bottom nav item label
    }

    @Test
    fun testNavigateToFavorites() {
        // Click on the "Favorites" bottom navigation item (using its text label)
        composeTestRule.onNodeWithText("Favorites").performClick()
        // Check if "Favorites Screen" text is displayed
        composeTestRule.onNodeWithText("Favorites Screen").assertIsDisplayed()
    }

    @Test
    fun testNavigateToMainScreen() {
        // Click on the "Main" bottom navigation item
        composeTestRule.onNodeWithText("Main").performClick()
        // Check if "Main Screen" text is displayed
        composeTestRule.onNodeWithText("Main Screen").assertIsDisplayed()
    }

    @Test
    fun testNavigateToSettings() {
        // Click on the "Settings" bottom navigation item
        composeTestRule.onNodeWithText("Settings").performClick()
        // Check if "Settings Screen" text is displayed
        composeTestRule.onNodeWithText("Settings Screen").assertIsDisplayed()
    }

    @Test
    fun testNavigateToProfile() {
        // Click on the "Profile" bottom navigation item
        composeTestRule.onNodeWithText("Profile").performClick()
        // Check if "Profile Screen" text is displayed
        composeTestRule.onNodeWithText("Profile Screen").assertIsDisplayed()
    }

    @Test
    fun testNavigationCycle() {
        // Test navigating through a few items sequentially
        composeTestRule.onNodeWithText("Favorites").performClick()
        composeTestRule.onNodeWithText("Favorites Screen").assertIsDisplayed()

        composeTestRule.onNodeWithText("Settings").performClick()
        composeTestRule.onNodeWithText("Settings Screen").assertIsDisplayed()

        composeTestRule.onNodeWithText("Home").performClick()
        composeTestRule.onNodeWithText("Home Screen").assertIsDisplayed()
    }
}
