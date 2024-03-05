package dl.thismatters.unitconverter.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random
//This Game is made to learn about functions like State Change and remember
//Here we are constantly changing the state of treasurefound and direction on click of any of the four given Buttons
@Composable
fun CaptainGame(){
    val treasurefound = remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    val distancetraveld = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Treasures Found: ${treasurefound.value}", modifier = Modifier.padding(15.dp), fontSize = 24.sp)
        Text(text = "Current Direction: ${direction.value}" ,modifier = Modifier.padding(15.dp), fontSize = 24.sp)
        Text(text = "Distance Travaled: ${distancetraveld.value}" ,modifier = Modifier.padding(15.dp), fontSize = 24.sp)

        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            direction.value = "East"
            distancetraveld.value += 1
            if (Random.nextBoolean()){
                treasurefound.value += 1
            }
        }, modifier = Modifier
            .height(80.dp)
            .width(250.dp))
        {
         Text(text = "Sail 1 nautical mile East")
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            direction.value = "West"
            distancetraveld.value += 1
            if (Random.nextBoolean()){
                treasurefound.value += 1
            }
        }, modifier = Modifier
            .height(80.dp)
            .width(250.dp))
        {
            Text(text = "Sail 1 nautical mile West")
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            direction.value = "North"
            distancetraveld.value += 1
            if (Random.nextBoolean()){
                treasurefound.value += 1
            }
        }, modifier = Modifier
            .height(80.dp)
            .width(250.dp))
        {
            Text(text = "Sail 1 nautical mile North")
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            direction.value = "South"
            distancetraveld.value += 1
            if (Random.nextBoolean()){
                treasurefound.value += 1
            }
        }, modifier = Modifier
            .height(80.dp)
            .width(250.dp))
        {
            Text(text = "Sail 1 nautical mile South")
        }
    }
}