package com.example.tiptime

import androidx.compose.runtime.Composable
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.runner.RunWith
import org.junit.Rule
import org.junit.Test
import com.example.tiptime.ui.theme.TipCalculatorTheme
import java.text.NumberFormat

class TipUITests {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    @Composable
    fun Calculate() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipTimeLayout()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found."
        )
    }
}