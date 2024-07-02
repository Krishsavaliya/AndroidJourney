package `in`.thismatters.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.thismatters.navigationsample.ui.theme.NavigationSampleAppTheme

@Composable
fun ThirdScreen(navtoFirstScreen:() -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
     Text(text = "This is Third Screen!!!", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navtoFirstScreen() }) {
            Text(text = "Go back to First Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdScreenPreview() {
    NavigationSampleAppTheme {
        ThirdScreen({})
    }
}