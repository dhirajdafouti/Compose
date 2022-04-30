package com.project.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.project.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    // Greeting("Android")
                    //CardGreeting()
                    MessageCard(Message("Android", "Jet Pack Compose"))
                }
            }

        }
    }


}

data class Message(var author: String, var message: String)

@ExperimentalAnimationApi
@Composable
fun CardGreeting() {
    Card {
        var expanded by remember { mutableStateOf(false) }
        Column(Modifier.clickable { expanded = !expanded }) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "hello")
            AnimatedVisibility(visible = expanded) {
                Text(
                    text = "JetPackCompose",
                    style = MaterialTheme.typography.h2
                )
            }

        }
    }
}

@Composable
fun Greeting(name: String) {
    Row {
        Column {
            Text(text = "Hello $name!")
        }
        Column {
            Text(text = "Dhiraj$name!")
        }
    }


}

@ExperimentalAnimationApi
@Preview(name="Light Mode",showBackground = true)
@Preview(name="Dark Mode",uiMode = Configuration.UI_MODE_NIGHT_YES,showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        // Greeting("Android")
        //  CardGreeting()
        MessageCard(Message("Android", "Jet Pack Compose"))
    }
}

@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier
        .background(Color.Transparent)) {
        Row {
            Column {
                Text(text = message.message,
                    color = MaterialTheme.colors.primaryVariant,
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .border(1.dp, MaterialTheme.colors.secondary, CircleShape),
                    fontFamily = FontFamily.Default)
                Spacer(modifier = Modifier.size(2.dp))
                Surface(shape = MaterialTheme.shapes.medium,elevation = 2.dp,color = MaterialTheme.colors.primary,border = BorderStroke(1.dp,
                    Color.Blue)) {
                    Text(text = message.author,
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .border(1.dp, MaterialTheme.colors.secondary, CircleShape)
                            .width(80.dp),
                        color = MaterialTheme.colors.primaryVariant,
                        fontFamily = FontFamily.Default,
                        fontSize = TextUnit.Unspecified)
                }
            }
        }
        Image(painterResource(R.drawable.ic_pic),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .border(1.5.dp, Color.Blue, CircleShape)
                .clip(CircleShape))

    }
}