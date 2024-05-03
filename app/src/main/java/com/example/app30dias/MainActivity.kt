package com.example.app30dias

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column



import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app30dias.Data.DaysData
import com.example.app30dias.Data.datList
import com.example.app30dias.ui.theme.App30diasTheme
import com.example.compose.backgroundLight
import com.example.compose.backgroundLightHighContrast

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
                    text = "30 Days App",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
        listDays(listdats = datList)
    }

}

@Composable
fun listDays(listdats : List<DaysData>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(listdats){ day ->
            DayCard(daycart = day,modifier = Modifier.padding(8.dp))

        }
    }
}

@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun DayCard(daycart: DaysData, modifier: Modifier = Modifier){
    val expandedState = remember { mutableStateOf(false) }
    Card(colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.primary
    ),
        modifier= modifier
        .graphicsLayer(scaleY = animateFloatAsState(if (expandedState.value) 1.1f else 1f).value)) {
        Column {
            Row(modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp, bottom = 5.dp, top = 8.dp)){
                Text(text = LocalContext.current.getString(daycart.tittle),
                    fontFamily = FontFamily(Font(R.font.blackhansans_regular),
                        Font(R.font.poetsenone_regular)),
                  )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = daycart.number_day.toString(),
                    fontFamily = FontFamily(Font(R.font.blackhansans_regular),
                        Font(R.font.poetsenone_regular)))
            }

            Text(text = LocalContext.current.getString(daycart.name),
                fontFamily = FontFamily(Font(R.font.blackhansans_regular, FontWeight.ExtraBold),
                    ),modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.Start))

            Spacer(modifier = Modifier.height(15.dp))
            Box(modifier = Modifier.clickable { expandedState.value = !expandedState.value }) {
                Image(
                    painter = painterResource(id = daycart.pic),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expandedState.value = !expandedState.value }
                      // ajusta este tamaño según tus necesidades
                )
            }
            if (expandedState.value
                ) {
                Text(color = Color.LightGray,
                    text = LocalContext.current.getString(daycart.content),
                    modifier = Modifier
                        .padding(start = 10.dp, bottom = 8.dp)
                        .align(Alignment.Start)
                    ,
                    fontFamily = FontFamily(Font(R.font.poetsenone_regular, FontWeight.Light
                    ,),
                    )// Añadir un espacio arriba para separar el texto de la imagen
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(26.dp))
}



@Composable
fun Content(daycart: DaysData) {
    val transition = updateTransition(targetState = true)
    val scaleY by transition.animateDp(
        transitionSpec = {
            tween(durationMillis = 300, easing = FastOutSlowInEasing)
        }
    ) { state ->
        if (state) 0.dp else 24.dp
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(scaleY)
    ) {
        Text(text = LocalContext.current.getString(daycart.content))
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