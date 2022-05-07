package com.project.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
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
                    //    MessageCard(Message("Android", "Jet Pack Compose"))
                    val viewModel = viewModel<MainViewModel>()
                    val time = viewModel.countDownFlow.collectAsState(initial = 10)
                    Row(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = time.value.toString(),
                            style = MaterialTheme.typography.h2,
                           fontSize=30.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
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
@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        // Greeting("Android")
        //  CardGreeting()
        // MessageCard(Message("Android", "Jet Pack Compose"))
        MessageCardList(message = SampleData.conversationSample)
    }
}

@Composable
fun MessageCardList(message: List<Message>) {
    LazyColumn {
        items(message) { message ->
            MessageCard(message)

        }
    }
}


@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier
        .background(Color.Transparent)) {
        Row {
            var isExpanded by remember {
                mutableStateOf(true)
            }
            // surfaceColor will be updated gradually from one color to the other
            val surfaceColor by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
            )
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(text = message.message,
                    color = MaterialTheme.colors.primaryVariant,
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .border(1.dp, MaterialTheme.colors.secondary, CircleShape),
                    fontFamily = FontFamily.Default)
                Spacer(modifier = Modifier.size(2.dp))
                Surface(shape = MaterialTheme.shapes.medium,
                    elevation = 2.dp,
                    color = MaterialTheme.colors.primary,
                    border = BorderStroke(1.dp,
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

object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        Message(
            "Colleague",
            "Test...Test...Test..."
        ),
        Message(
            "Colleague",
            "List of Android versions:\n" +
                    "Android KitKat (API 19)\n" +
                    "Android Lollipop (API 21)\n" +
                    "Android Marshmallow (API 23)\n" +
                    "Android Nougat (API 24)\n" +
                    "Android Oreo (API 26)\n" +
                    "Android Pie (API 28)\n" +
                    "Android 10 (API 29)\n" +
                    "Android 11 (API 30)\n" +
                    "Android 12 (API 31)\n"
        ),
        Message(
            "Colleague",
            "I think Kotlin is my favorite programming language.\n" +
                    "It's so much fun!"
        ),
        Message(
            "Colleague",
            "Searching for alternatives to XML layouts..."
        ),
        Message(
            "Colleague",
            "Hey, take a look at Jetpack Compose, it's great!\n" +
                    "It's the Android's modern toolkit for building native UI." +
                    "It simplifies and accelerates UI development on Android." +
                    "Less code, powerful tools, and intuitive Kotlin APIs :)"
        ),
        Message(
            "Colleague",
            "It's available from API 21+ :)"
        ),
        Message(
            "Colleague",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "Colleague",
            "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "Colleague",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "Colleague",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "Colleague",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "Colleague",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
    )
}