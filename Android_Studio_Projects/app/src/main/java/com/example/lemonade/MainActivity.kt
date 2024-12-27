package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                   LemonadeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(){

    var currScreen by remember { mutableStateOf(1) }

    var squeeztime by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text( "Lemonade", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        }
    )
    {innerPadding->
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ){when(currScreen){
            1-> LemonadeappUi(
                textLabelResourseId = R.string.Lemon_tree,
                drawableResourseId = R.drawable.lemon_tree,
                contentDiscriptionId = R.string.Lemon_tree,
                onImageClick = {
                    currScreen = 2
                    squeeztime = (2..4).random()
                }
            )
            2-> LemonadeappUi(
                textLabelResourseId = R.string.Lemon,
                drawableResourseId = R.drawable.lemon_squeeze,
                contentDiscriptionId = R.string.Lemon,
                onImageClick = {
                    squeeztime--
                    if (squeeztime == 0){
                        currScreen = 3
                    }
                }
            )
            3-> LemonadeappUi(
                textLabelResourseId = R.string.Glass_of_lemonade,
                drawableResourseId = R.drawable.lemon_drink,
                contentDiscriptionId = R.string.Glass_of_lemonade,
                onImageClick = {
                    currScreen = 4
                }
            )
            4-> LemonadeappUi(
                textLabelResourseId = R.string.Empty_glass,
                drawableResourseId = R.drawable.lemon_restart,
                contentDiscriptionId = R.string.Empty_glass,
                onImageClick = {
                    currScreen = 1
                }
            )
        }
        }

    }
}

@Composable
fun LemonadeappUi(
    textLabelResourseId:Int,
    drawableResourseId:Int,
    onImageClick:()->Unit,
    contentDiscriptionId:Int,
    modifier: Modifier=Modifier
){
    Box(modifier = modifier){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(drawableResourseId),
                    contentDescription = stringResource(contentDiscriptionId)
                    )
            }
            Spacer(Modifier.height(16.dp))
            Text(text = stringResource(textLabelResourseId),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }




}




@Preview
@Composable
fun LemonPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}
