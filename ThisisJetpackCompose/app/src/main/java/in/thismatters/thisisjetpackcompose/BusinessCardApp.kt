package `in`.thismatters.thisisjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.thismatters.thisisjetpackcompose.ui.theme.ThisisJetpackComposeTheme

@Composable
fun Card(){
//    Main column------
    Box {
        val image = painterResource(R.drawable.dark_orange_background_rvdlb3hv6dej8mpo)
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            //      First Column Image,Name
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.5f),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val logoimg = painterResource(R.drawable.android_logo)
                Image(
                    modifier = Modifier.height(200.dp),
                    painter = logoimg,
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )

                Text(
                    "Krish Savaliya",
                    fontSize = 36.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFffffff)

                )

                Text(
                    "Android and Flutter Develpoer",
                    fontSize =20.sp,
                    color = Color(0xFFffffff)
                )

            }

            //      Second column Phone no.,git link
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.5f),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {

                val myappicons = Icons.Rounded
                //          Row 1 Phone Number-----
                Row {
                    Icon(imageVector = Icons.Default.Call, contentDescription = null, tint = Color(0xFFffffff))
                    Spacer(Modifier.width(16.dp))
                    Text("8511163800",
                        fontSize =16.sp,
                        color = Color(0xFFffffff))
                }

                //          Row 2 GitHub Link-----
                Row {
                    Image(
                        painter = painterResource(R.drawable.github_mark_white),
                        modifier = Modifier.height(20.dp),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                    Spacer(Modifier.width(16.dp))
                    Text("https://github.com/Krishsavaliya",
                        fontSize =16.sp,
                        color = Color(0xFFffffff))
                }

                //          Row 3 Mail Id-----
                Row {
                    Icon(imageVector = Icons.Default.Call, contentDescription = null, tint = Color(0xFFffffff))
                    Spacer(Modifier.width(16.dp))
                    Text("krishrsavaliya@gmail.com",
                        fontSize =16.sp,
                        color = Color(0xFFffffff))
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ThisisJetpackComposeTheme {
        Card()
    }
}