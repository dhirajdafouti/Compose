package com.project.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.TextStyle
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
                  //  MessageCard(Message("Android", "Hey i am new to jet packcompose"))
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
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        // Greeting("Android")
        //  CardGreeting()
       // MessageCard(Message("Android", "Jet Pack Compose"))
    }
}

@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier
        .padding(5.dp)
        .background(Color.Transparent)) {

        Row {
            Column {
                Text(text = message.message,
                    style = TextStyle.Default,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Default)
                Spacer(modifier = Modifier.size(2.dp))
                Text(text = message.author,
                    style = TextStyle.Default,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Default,
                    fontSize = TextUnit.Unspecified)
            }
        }
        Image(painterResource(R.drawable.ic_pic),
            contentDescription = "Image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape))
    }
}