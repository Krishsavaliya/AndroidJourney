package `in`.thismatters.jetpackbasics

import android.graphics.drawable.Icon
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BusinessCard(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFd1e6e0))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        val androidLogo = painterResource(id = R.drawable.bugtroid)
        Image(painter = androidLogo, contentDescription = null,
                modifier = Modifier
                    .size(164.dp)
                    .clip(RoundedCornerShape(32.dp))
                    .background(Color(0xFF0d8f2d)),
            alignment = Alignment.TopCenter
            )

        Text(
            text = "Krish Savaliya",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontFamily =FontFamily.Cursive
            )
        Text(
            text = "Android F**king Developer",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontFamily =FontFamily.Cursive
            )

        Spacer(modifier = Modifier.height(24.dp))

        ContactInfo(
            phone = "+91 8511163800",
            githandle = "https://github.com/Krishsavaliya",
            mailid = "krishsavaliya17103@gmail.com",
        )
    }

}
@Composable
fun ContactInfo(
    modifier: Modifier = Modifier,
    phone: String,
    githandle: String,
    mailid: String,
){
    Spacer(modifier = Modifier.height(16.dp))
    Row(modifier = Modifier

    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(140.dp)
                .weight(0.2f)
        ) {
            androidx.compose.material3.Icon(imageVector = Icons.Default.Phone, contentDescription = null,
                tint = Color(0xFF3ee6b6) ,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(32.dp)
                    .background(Color(0xFF9116ba))

            )
            Icon(imageVector = Icons.Default.Build, contentDescription = null,
                tint = Color(0xFF3ee6b6),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(32.dp)
                    .background(Color(0xFF9116ba))

            )
            Icon(imageVector = Icons.Default.Email, contentDescription = null,
                tint = Color(0xFF3ee6b6) ,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(32.dp)
                    .background(Color(0xFF9116ba))

            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = phone,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier
                    .padding(
                    top = 8.dp,
                    bottom = 8.dp
                )

            )
            Text(
                text = githandle,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier.padding(
                    top = 8.dp,
                    bottom = 8.dp
                )
            )
            Text(
                text = mailid,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier.padding(
                    top = 8.dp,
                    bottom = 8.dp
                )
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBusinessCard(){
    BusinessCard()
}
