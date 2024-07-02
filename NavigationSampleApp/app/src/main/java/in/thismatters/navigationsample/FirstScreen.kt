package `in`.thismatters.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.thismatters.navigationsample.ui.theme.NavigationSampleAppTheme

@Composable
fun FirstScreen(navToSecondScreen:(String)->Unit){
    val name = remember {
        mutableStateOf("")
    }

    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is The FirstScreen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name.value, onValueChange = {
            name.value = it
        })
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navToSecondScreen(name.value)
            }) {
            Text(text = "Go TO Next Page")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    NavigationSampleAppTheme {
        FirstScreen({})
    }
}