package dl.thismatters.unitconverter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UnitConverter2(){
    Column {
        Text(text = "Unit Converter 2!!")
        OutlinedTextField(value = "", onValueChange ={})
        Row {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Select")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun UniteConvertorPreview2(){
    UniteConvertor()
}