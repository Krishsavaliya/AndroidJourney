package `in`.thismatters.thisisjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import `in`.thismatters.thisisjetpackcompose.ui.theme.ThisisJetpackComposeTheme
import java.text.NumberFormat
import kotlin.jvm.internal.Intrinsics.Kotlin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThisisJetpackComposeTheme {
                    TipCalculatorLayout()

                }
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipCalculatorLayout(){
    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }

    var amount = amountInput.toDoubleOrNull()?: 0.0
    var tipPercent = tipInput.toDoubleOrNull()?:0.0

    var tip = calculateTip(amount,tipPercent,roundUp)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Tip Time App", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                )
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 40.dp)
                .verticalScroll(rememberScrollState())
                .safeContentPadding(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.calculate_tip),
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(bottom = 16.dp, top = 40.dp)
            )

            EditNuberField(
                label = R.string.bill_amount,
                leadingIcon = R.drawable.money,
                value = amountInput,
                onValueChange = { amountInput = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            EditNuberField(
                label = R.string.how_was_the_service,
                leadingIcon = R.drawable.percent,
                value = tipInput,
                onValueChange = { tipInput = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )

            RoundTheTipRow(
                roundUp = roundUp,
                onRoundUpChanged = { roundUp = it },
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Text(
                text = stringResource(R.string.tip_amount, tip),
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(modifier = Modifier.height(150.dp))
        }
    }

}
@Composable
fun EditNuberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon:Int,
    value : String,
    onValueChange: (String)->Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
){
    TextField(
        label = { Text(stringResource(label)) },
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon),null) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
    )
}

@Composable
fun RoundTheTipRow(
    roundUp: Boolean,
    onRoundUpChanged:(Boolean)->Unit,
    modifier: Modifier=Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        )
    }
}

@VisibleForTesting
internal fun calculateTip(
    amount:Double,
    tipPercent:Double,
    roundUp: Boolean
):String{
    var tip = tipPercent/100*amount
    if (roundUp){
        tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThisisJetpackComposeTheme {
        TipCalculatorLayout()
    }
}