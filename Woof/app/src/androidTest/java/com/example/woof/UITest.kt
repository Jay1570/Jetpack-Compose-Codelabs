package com.example.woof

import androidx.compose.ui.test.junit4.createComposeRule
import com.example.woof.ui.theme.WoofTheme
import org.junit.Rule
import org.junit.Test

class UITest {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun UI() {
        composeTestRule.setContent {
            WoofTheme {
                WoofApp()
            }
        }
        
    }
}