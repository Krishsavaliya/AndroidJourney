package `in`.thismatters.carwaleapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CarWale(){
    Column( modifier = Modifier
        .height(32.dp),
        verticalArrangement = Arrangement.Top

    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(16.dp),

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text( "CarWale", fontWeight = FontWeight.ExtraBold, fontSize =32.sp, color = Color.White)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Magenta)
                .padding(8.dp)
                .height(32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text( "Home", fontWeight = FontWeight.ExtraBold, fontSize =16.sp)
            Text( "About Us", fontWeight = FontWeight.ExtraBold, fontSize =16.sp)
            Text( "Contact Us", fontWeight = FontWeight.ExtraBold, fontSize =16.sp)
            Text( "Login", fontWeight = FontWeight.ExtraBold, fontSize =16.sp)
        }

        LazyVerticalGrid(GridCells.Fixed(1),
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Gray)
        ){
            Column {
                Image(painter = , contentDescription = "BMW")
            }

        }


    }


}


@Preview(showBackground = true)
@Composable
fun CarWaleAppPreview(){
    CarWale()
}