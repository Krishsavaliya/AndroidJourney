package `in`.thismatters.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import `in`.thismatters.navigationsample.ui.theme.NavigationSampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen"){
        composable(route = "firstscreen"){
            FirstScreen {name->
                navController.navigate("secondscreen/$name")
            }
        }
        composable(route = "secondscreen/{name}"){
            val name =it.arguments?.getString("name")?:"no name"
            SecondScreen(name) {
                navController.navigate("thirdscreen")
            }
        }
        composable(route="thirdscreen"){
            ThirdScreen {
                navController.navigate("firstscreen")
            }
        }
    }
}

