package `in`.thismatters.jetpackbasics

import android.support.v4.os.IResultReceiver2.Default
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun QuadrantTask(){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            QuadrantInfoCard(
                title = stringResource(R.string.quadrant_1_title),
                description = stringResource(R.string.quadrant_1_description),
                bgcolor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            QuadrantInfoCard(
                title = stringResource(R.string.quadrant_2_title),
                description = stringResource(R.string.quadrant_2_description),
                bgcolor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            QuadrantInfoCard(
                title = stringResource(R.string.quadrant_3_title),
                description = stringResource(R.string.quadrant_3_description),
                bgcolor =Color(0xFFB69DF8) ,
                modifier = Modifier.weight(1f)
            )
            QuadrantInfoCard(
                title = stringResource(R.string.quadrant_4_title),
                description = stringResource(R.string.quadrant_4_description),
                bgcolor =Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantInfoCard(
    title : String,
    description : String,
    bgcolor : Color,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgcolor)
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp,
                top = 16.dp
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
            )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewComposeQuadrant(){
    QuadrantTask()
}