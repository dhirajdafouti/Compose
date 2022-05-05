package com.project.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                NamePickerItem(name.message+name.author, onNameClicked)
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MyApplicationTheme {
        // DynamicText(SampleData2.noConversation)
        // MessageList(SampleData2.conversationSample)
      //NamePicker(header = "Items", names = SampleData2.conversationSample)
    }
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