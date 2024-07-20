package `in`.thismatters.jetpackbasics

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Composeartical(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image_jetpack = painterResource(id = R.drawable.bg_compose_background)
        Image(
            painter = image_jetpack,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = stringResource(R.string.compose_artical_title),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.compose_artical_text_1),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp, bottom = 16.dp
                ),
            textAlign = TextAlign.Justify

        )
        Text(
            text = stringResource(R.string.compose_artical_text_2),
            fontSize = 16.sp,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp, bottom = 16.dp
            ),
            textAlign = TextAlign.Justify
        )
    }
    Box {

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComposeArtical(){
    Composeartical()
}