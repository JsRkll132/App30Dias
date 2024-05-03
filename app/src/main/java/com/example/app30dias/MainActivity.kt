package com.example.app30dias

import android.os.Bundle
import android.speech.ModelDownloadListener
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app30dias.Data.DaysData
import com.example.app30dias.Data.datList
import com.example.app30dias.ui.theme.App30diasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App30diasTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Column {
        TopAppBar(
            title = {
                Text(
                    text = "Título de la App",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            },
            modifier = Modifier.fillMaxWidth(),
        )
        listDays(listdats = datList)
    }

}

@Composable
fun listDays(listdats : List<DaysData>,modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(listdats){ day ->
            DayCard(daycart = day,modifier = Modifier.padding(8.dp))

        }
    }
}

@Composable
fun DayCard(daycart:DaysData,modifier: Modifier = Modifier){
    Card(modifier= modifier) {
        Column {
            Row {
                Text(text = LocalContext.current.getString(daycart.tittle))
                Text(text = daycart.number_day.toString())
            }

            Text(text = LocalContext.current.getString(daycart.name))

            Clickable(onClick = { /* acción cuando se hace clic en la imagen */ }) {
                // Establece el tamaño de la imagen
                Image(
                    painter = painterResource(id = daycart.pic),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                // ajusta este tamaño según tus necesidade
                )
            }
            Text(text = LocalContext.current.getString(daycart.content))
        }
    }
}

@Composable
fun Clickable(onClick: () -> Unit, content: @Composable () -> Unit) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App30diasTheme {
        Greeting("Android")
    }
}