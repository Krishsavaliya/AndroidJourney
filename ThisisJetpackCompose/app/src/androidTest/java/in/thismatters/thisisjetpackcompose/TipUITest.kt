package `in`.thismatters.thisisjetpackcompose

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import `in`.thismatters.thisisjetpackcompose.ui.theme.ThisisJetpackComposeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculateTip_20_Percent_tip(){
        composeTestRule.setContent {
            ThisisJetpackComposeTheme {
                TipCalculatorLayout()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists("No node with text Found.")
    }

}