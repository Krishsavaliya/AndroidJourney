package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtspaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtspaceAppTheme {
                ArtSpaceApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceApp(){

    var currScreen by remember { mutableStateOf(1) }

    Scaffold(
        topBar ={
            CenterAlignedTopAppBar(
                title = { Text("ArtSpace App", fontWeight = FontWeight.Bold)},
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        }

    ) { innerPadding->
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {when(currScreen){
            1-> ArtSpaceeUi(
                drawableResource = R.drawable.image_1,
                textLableResourse = R.string.image1,
                contentDiscriptionResource = R.string.image1d,
                onNextButtonClicked = {
                    currScreen = 2
                },
                onPrevButtonClicked = {
                    currScreen = 10
                }
            )
            2-> ArtSpaceeUi(
                    drawableResource = R.drawable.image_2,
                    textLableResourse = R.string.image2,
                    contentDiscriptionResource = R.string.image2d,
                    onNextButtonClicked = {
                        currScreen = 3
                    },
                    onPrevButtonClicked = {
                        currScreen = 1
                    }
                )
            3-> ArtSpaceeUi(
                    drawableResource = R.drawable.image_3,
                    textLableResourse = R.string.image3,
                    contentDiscriptionResource = R.string.image3d,
                    onNextButtonClicked = {
                        currScreen = 4
                    },
                    onPrevButtonClicked = {
                        currScreen = 2
                    }
                )
            4-> ArtSpaceeUi(
                    drawableResource = R.drawable.image_4,
                    textLableResourse = R.string.image4,
                    contentDiscriptionResource = R.string.image4d,
                    onNextButtonClicked = {
                        currScreen = 5
                    },
                    onPrevButtonClicked = {
                        currScreen = 3
                    }
                )
            5-> ArtSpaceeUi(
                    drawableResource = R.drawable.image_5,
                    textLableResourse = R.string.image5,
                    contentDiscriptionResource = R.string.image5d,
                    onNextButtonClicked = {
                        currScreen = 6
                    },
                    onPrevButtonClicked = {
                        currScreen = 4
                    }
                )
            6-> ArtSpaceeUi(
                    drawableResource = R.drawable.image_6,
                    textLableResourse = R.string.image6,
                    contentDiscriptionResource = R.string.image6d,
                    onNextButtonClicked = {
                        currScreen = 7
                    },
                    onPrevButtonClicked = {
                        currScreen = 5
                    }
                )
            7-> ArtSpaceeUi(
                    drawableResource = R.drawable.image_7,
                    textLableResourse = R.string.image7,
                    contentDiscriptionResource = R.string.image7d,
                    onNextButtonClicked = {
                        currScreen = 8
                    },
                    onPrevButtonClicked = {
                        currScreen = 6
                    }
                )
            8-> ArtSpaceeUi(
                    drawableResource = R.drawable.image_8,
                    textLableResourse = R.string.image8,
                    contentDiscriptionResource = R.string.image8d,
                    onNextButtonClicked = {
                        currScreen = 9
                    },
                    onPrevButtonClicked = {
                        currScreen = 7
                    }
                )
            9-> ArtSpaceeUi(
                    drawableResource = R.drawable.image_9,
                    textLableResourse = R.string.image9,
                    contentDiscriptionResource = R.string.image9d,
                    onNextButtonClicked = {
                        currScreen = 10
                    },
                    onPrevButtonClicked = {
                        currScreen = 8
                    }
                )
            10-> ArtSpaceeUi(
                    drawableResource = R.drawable.image_10,
                    textLableResourse = R.string.image10,
                    contentDiscriptionResource = R.string.image10d,
                    onNextButtonClicked = {
                        currScreen = 1
                    },
                    onPrevButtonClicked = {
                        currScreen = 9
                    }
                )
        }

        }

    }

}

@Composable
fun ArtSpaceeUi(
    drawableResource: Int,
    textLableResourse: Int,
    contentDiscriptionResource: Int,
    onNextButtonClicked: () -> Unit,
    onPrevButtonClicked: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 64.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                Modifier
                    .height(428.dp)
                    .width(440.dp)
            ) {
                Image(
                    painter = painterResource(drawableResource),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .shadow(elevation = 8.dp)
                )
            }
            Spacer(Modifier.height(16.dp))

            Text(
                text = stringResource(textLableResourse),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                    )
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                    .fillMaxWidth()

            )
            Text(
                text = stringResource(contentDiscriptionResource), fontSize = 18.sp,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)
                    )
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .fillMaxWidth()

            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier
                    .width(120.dp)
                    .height(48.dp),
                onClick = onPrevButtonClicked
            ) {
                Text("Previous")
            }
            Button(
                modifier = Modifier
                    .width(120.dp)
                    .height(48.dp),
                onClick = onNextButtonClicked
            ) {
                Text("Next")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtspaceAppTheme {
        ArtSpaceApp()
    }
}
