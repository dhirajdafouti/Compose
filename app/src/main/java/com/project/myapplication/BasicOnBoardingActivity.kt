package com.project.myapplication

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.project.myapplication.ui.theme.MyApplicationTheme

class BasicOnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.onError,
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 8.dp)) {
                    //Greeting2(SampleData2.noConversation)
                    //  MessageList(SampleData2.conversationSample)
//                    var name by rememberSaveable {
//                        mutableStateOf("")
//                    }
//                    HelloContent(name, onNameClicked = {
//                        name = it
//                    })
                    // MyApp()
                    WaterCounter(modifier = Modifier)

                }
            }
        }
    }
}


@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = modifier
                .weight(1f)
                .padding(16.dp),
            text = taskName
        )
        IconButton(onClick = { onClose }) {
            Icon(painterResource(R.drawable.ic_launcher_foreground), "")
        }

    }

}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column(modifier = modifier.padding(16.dp)) {
            var count by remember {
                mutableStateOf(0)
            }

            if (count > 0) {
                var showTask by remember {
                    mutableStateOf(true)
                }
                if (showTask) {
                    WellnessTaskItem(taskName = "Have you take water in 15 mins", onClose = {
                     showTask=false
                    })
                }
                Text("You have $count glasses", modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp))
            }
            Row(modifier = modifier.weight(1f)) {
                Button(onClick = {
                    count++
                }, modifier.padding(6.dp), enabled = count < 0) {
                    Text("Add one")
                }
                Button(onClick = {
                    count = 0
                }, modifier.padding(6.dp)) {
                    Text("Clear Water Count ")
                }
            }
        }

    }

}

@Composable
fun MyApp() {
    var shouldShowOnBoarding by rememberSaveable {
        mutableStateOf(true)
    }
    if (shouldShowOnBoarding) {
        OnboardingScreen(onContinueClicked = {
            shouldShowOnBoarding = false
        })
    } else {
        val names: List<String> = List(100) { "$it" }
        HelloWorld(names)
    }
}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {

    Surface(color = MaterialTheme.colors.secondaryVariant) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Welcome to the Basic CodeLabs")
            Button(modifier = Modifier.padding(vertical = 20.dp),
                onClick = onContinueClicked) {
                Text(text = "Continue")

            }
        }

    }

}

//@Preview(showBackground = true, widthDp = 320, heightDp = 320, uiMode = UI_MODE_NIGHT_YES)
//@Composable
//fun OnboardingPreview() {
//    // MyApplicationTheme {
//    //   OnboardingScreen(onContinueClicked = {})
//    WaterCounter(modifier = Modifier)
//    //  }
//}


@Composable
fun HelloWorld(names: List<String>) {
    LazyColumn(modifier = Modifier
        .padding(vertical = 4.dp, horizontal = 4.dp)
        .background(Color.Green)) {
        items(items = names) { name ->
            ComposeValues(name = name)
        }

    }
}

@Composable
fun ComposeValues(name: String) {
    Surface(color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 2.dp, horizontal = 2.dp)) {
        val expanded = remember {
            mutableStateOf(false)
        }
        val extraPadding = if (expanded.value) 49.dp else 0.dp
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 20.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Hello", style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.Black
                ))
                Text(text = ",$name", style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.ExtraBold
                ))
            }
            OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "Show More" else "Show Less", textAlign = TextAlign.Center)

            }
        }

    }
}

@Composable
fun NamePicker(
    header: String,
    names: List<Message>,
    onNameClicked: (String) -> Unit,
) {
    Column {
        Text(header, style = MaterialTheme.typography.h5)
        Divider(modifier = Modifier.size(2.dp),
            thickness = 2.dp,
            color = MaterialTheme.colors.primary)

        LazyColumn {
            items(names) { name ->
                NamePickerItem(name.message + name.author, onNameClicked)
            }
        }
    }
}

@Composable
fun NamePickerItem(name: String, onNameClicked: (String) -> Unit) {
    Text(name, Modifier.clickable {
        onNameClicked(name)
    })
}


@Composable
fun Greeting2(message: List<Message>) {
    Column {
        if (message.isEmpty()) {
            Text(text = "I am a super idiotic husband!!!..")
        } else {
            message.forEach { message ->
                Text(text = message.message)
            }
        }
    }
}


@Composable
fun CartItem() {
    var quantity = remember {
        mutableStateOf(1)
    }
    Row {
        Image(painterResource(R.drawable.ic_pic),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .border(1.5.dp, Color.Blue, CircleShape)
                .clip(CircleShape))
        Row {
            Button(onClick = { quantity.value++ }) {
                Text(text = "+", modifier = Modifier
                    .width(5.dp)
                    .height(5.dp), Color.Black)
            }
            Text(quantity.value.toString())
            Button(onClick = { quantity.value-- }) {
                Text(text = "-",
                    modifier = Modifier
                        .width(5.dp)
                        .height(5.dp),
                    Color.Black,
                    fontFamily = FontFamily.Cursive,
                    fontSize = TextUnit.Unspecified)
            }
        }

    }

}

@Composable
fun HelloContent(name: String, onNameClicked: (String) -> Unit) {
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        if (name.isEmpty()) {
            Text(
                text = "Hello World $name ",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(bottom = 10.dp),
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
            )
        }
        OutlinedTextField(value = name,
            onValueChange = onNameClicked,
            label = { Text(text = "Name ") })

    }

}

//@Preview(showBackground = true,uiMode = UI_MODE_NIGHT_YES)
//@Composable
//fun DefaultPreview2() {
//
//    //   CartItem()
//    var name by rememberSaveable {
//        mutableStateOf("")
//    }
////    Surface(color = MaterialTheme.colors.error) {
////
////        HelloContent(name, onNameClicked = {
////            name = it
////        })
////    }
//    // DynamicText(SampleData2.noConversation)
//    // MessageList(SampleData2.conversationSample)
//    // NamePicker(header = "Items", names = SampleData2.conversationSample,onNameClicked = {
//    val values: List<String> = List(100) { "$it" }
//    HelloWorld(values)
//    //    })
//
//}

@Composable
fun MessageList(conversationSample: List<Message>) {
    Row {
        Column {

            if (conversationSample.isEmpty()) {
                Text(text = "I am a super idiotic husband!!!..")
            } else {
                conversationSample.forEach { message ->
                    Text(text = message.message)
                    var selectedAll by remember {
                        mutableStateOf(false)
                    }
                    Checkbox(
                        checked = selectedAll,
                        onCheckedChange = { checked ->
                            selectedAll = checked
                        }
                    )
                }

            }

        }
    }
}


object SampleData2 {
    // Sample conversation data
    val conversationSample = listOf(
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
        )
    )
    val noConversation = listOf<Message>()
}