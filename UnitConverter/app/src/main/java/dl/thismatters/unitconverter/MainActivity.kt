package dl.thismatters.unitconverter

import android.graphics.Paint.Style
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dl.thismatters.unitconverter.ui.theme.CaptainGame
import dl.thismatters.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    CaptainGame()
                    UniteConvertor()
                }
            }
        }
    }
}
@Composable
fun UniteConvertor(){

    Box (modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.bg_img4) ,
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        
        var inputValue by remember { mutableStateOf("") }
        var outputValue by remember { mutableStateOf("") }
        var inputUnit by remember { mutableStateOf("Select") }
        var outputUnit by remember { mutableStateOf("Select") }
        var iExpanded by remember { mutableStateOf(false) }
        var oExpanded by remember { mutableStateOf(false) }
        val convertionRate = remember { mutableStateOf(1.00) }
        val oconvertionRate = remember { mutableStateOf(1.00) }

        fun convertionUnits() {
            //?: -elvish operater
            val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
            val result =
                (inputValueDouble * convertionRate.value * 100.0 / oconvertionRate.value).roundToInt() / 100.0
            outputValue = result.toString()
        }

        Column(
            //This contains Row,which contains Boxes
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //This are types of Text Fields in kotlin
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Unit Convertor",
                modifier = Modifier.padding(10.dp),
                fontSize = 34.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = inputValue,
                onValueChange =
                {
                    inputValue = it
                    convertionUnits()
                },
                label = { Text(text = "Enter Value :)") })
            //        TextField(value = , onValueChange = )
            //        BasicTextField(value = ) {
            //        }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                //          Input Box
                Box {
                    //                Input Button
                    Button(
                        onClick = { iExpanded = true }, modifier = Modifier
                            .height(60.dp)
                            .width(154.dp)
                    ) {
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "To Select unit to convert"
                        )
                        Text(text = "${inputUnit}")
                    }
                    DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                        DropdownMenuItem(
                            text = { Text(text = "Centimeter") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Centimeter"
                                convertionRate.value = 0.01

                            })
                        DropdownMenuItem(text = { Text(text = "Meter") }, onClick = {
                            iExpanded = false
                            inputUnit = "Meter"
                            convertionRate.value = 1.00
                        })
                        DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                            iExpanded = false
                            inputUnit = "Feet"
                            convertionRate.value = 0.3048
                        })
                        DropdownMenuItem(text = { Text(text = "Millimeter") }, onClick = {
                            iExpanded = false
                            inputUnit = "Millimeter"
                            convertionRate.value = 0.001
                        })
                    }
                }
                Spacer(modifier = Modifier.width(20.dp))
                //            Output Box
                Box {
                    //                Output Button
                    Button(
                        onClick = { oExpanded = true }, modifier = Modifier
                            .height(60.dp)
                            .width(154.dp)
                    ) {
                        Text(text = "${outputUnit}")
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "To Select unit to convert"
                        )
                    }
                    DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                        DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick =
                        {
                            oExpanded = false
                            outputUnit = "Centimeter"
                            oconvertionRate.value = 0.01

                        })
                        DropdownMenuItem(text = { Text(text = "Meter") }, onClick =
                        {
                            oExpanded = false
                            outputUnit = "Meter"
                            oconvertionRate.value = 1.00

                        })
                        DropdownMenuItem(text = { Text(text = "Feet") }, onClick =
                        {
                            oExpanded = false
                            outputUnit = "Feet"
                            oconvertionRate.value = 0.3048

                        })
                        DropdownMenuItem(text = { Text(text = "Millimeter") }, onClick =
                        {
                            oExpanded = false
                            outputUnit = "Millimeter"
                            oconvertionRate.value = 0.001

                        })
                    }
                }

            }
            Spacer(modifier = Modifier.height(50.dp))
            Box {
                Button(
                    onClick =
                    {
                        oExpanded = false
                        iExpanded = false
                        convertionUnits()
                    }, modifier = Modifier
                        .height(60.dp)
                        .width(200.dp)
                ) {
                    Text(text = "Calculate", fontSize = 24.sp, fontFamily = FontFamily.SansSerif)
                }
            }
            Spacer(modifier = Modifier.height(100.dp))
            Text( "Result: ${outputValue} $outputUnit",
                style = MaterialTheme.typography.headlineMedium
                )
//                fontSize = 30.sp, fontFamily = FontFamily.Cursive)
            Spacer(modifier = Modifier.height(10.dp))
            //This is an example of Toast & Button
            //            val context = LocalContext.current
            //            Button(onClick = { Toast.makeText(context, "This is an error toast.", Toast.LENGTH_SHORT).show()}) {
            //                Text(text = "Click Me!!")
            //            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UniteConvertorPreview(){
    UniteConvertor()
}