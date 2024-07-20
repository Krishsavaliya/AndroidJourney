package `in`.thismatters.navigationcodingexersice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import `in`.thismatters.navigationcodingexersice.ui.theme.NavigationCodingExersiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationCodingExersiceTheme {
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
    NavHost(navController = navController   , startDestination = "firstscreen" ){
        composable(route = "firstscreen"){
            FirstScreen {name,age->
                navController.navigate("secondscreen/$name/$age")
            }
        }
        composable(route = "secondscreen/{name}/{age}"){
            val name =it.arguments?.getString("name")?:"Krish"
            val age = it.arguments?.getString("age")?:"11"
            SecondScreen(name,age.toInt())
        }
    }
}