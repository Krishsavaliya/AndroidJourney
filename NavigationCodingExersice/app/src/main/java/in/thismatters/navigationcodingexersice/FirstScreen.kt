package `in`.thismatters.navigationcodingexersice

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

@Composable
fun FirstScreen(navigatetosecondscreen: (String,Int)->Unit){
    var name = remember {
        mutableStateOf("")
    }
    var age = remember {
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
        Text(text = "Enter Your Name", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name.value, onValueChange = {name.value = it})
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Enter Your Age", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = age.value, onValueChange = {age.value = it})
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
             navigatetosecondscreen(name.value.toString(),age.value.toInt())
        }) {
            Text(text = "Go to Next Page",fontSize = 24.sp)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun FirstScreenPreview(){
//    FirstScreen({})
//}