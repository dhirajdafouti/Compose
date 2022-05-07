package com.project.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.project.myapplication.ui.theme.MyApplicationTheme

class SampleActivity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Greeting2(SampleData2.noConversation)
                    //  MessageList(SampleData2.conversationSample)
                 HelloContent()

                }
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
    val quantity = remember {
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
fun HelloContent() {
    Column(modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,) {
        Text(text = "Hello World",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 8.dp),fontStyle = FontStyle.Normal,textAlign = TextAlign.Center,color = Color.Blue)
        OutlinedTextField(value = "", onValueChange = {}, label = { Text(text = "Name") })


    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {

    //   CartItem()
    HelloContent()
    // DynamicText(SampleData2.noConversation)
    // MessageList(SampleData2.conversationSample)
    // NamePicker(header = "Items", names = SampleData2.conversationSample,onNameClicked = {

    //    })

}

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