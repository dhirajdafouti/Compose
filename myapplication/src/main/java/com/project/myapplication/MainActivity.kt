package com.project.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.primaryVariant) {
                    AlertDialog()
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AlertDialog() {
    var showPopup by remember { mutableStateOf(false) }
    Surface(modifier = Modifier.padding(10.dp),
        shape = MaterialTheme.shapes.small,
        color = Color.Transparent) {
        Column(Modifier
            .width(100.dp)
            .height(100.dp)
            .padding(10.dp)
            .background(Color.Green)) {
            Text(text = "Alert Dialog Display")
            Card(shape = RoundedCornerShape(6.dp), enabled = true, border = BorderStroke(10.dp,
                Color.Black),
                backgroundColor = Color.Magenta,
                onClick = { showPopup = false }) {
                Text(
                    text = "Click to see dialog", modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Serif
                    )
                )

            }
        }

    }
    var onPopupDismissed={
        showPopup=false
    }

    if (showPopup) {
        // Predefined composable provided by the material implementations of Jetpack Compose. It
        // shows a simple alert dialog on the screen if this code path is executed (i.e showPopup
        // variable is true)
        AlertDialog(
            onDismissRequest = onPopupDismissed,
            text = {
                Text("Congratulations! You just clicked the text successfully")
            },
            confirmButton = {
                // Button is a pre-defined Material Design implementation of a contained button -
                // https://material.io/design/components/buttons.html#contained-button.
                Button(
                    onClick = onPopupDismissed
                ) {
                    // The Button composable allows you to provide child composables that inherit
                    // this button functionality.
                    // The Text composable is pre-defined by the Compose UI library; you can use this
                    // composable to render text on the screen
                    Text(text = "Ok")
                }
            })
    }

}


@Preview(showBackground = true, widthDp = 300, heightDp = 300, backgroundColor = 0xFFF0EAE2)
@Composable
fun DefaultPreviewAlertDialog() {
    MyApplicationTheme {
       // AlertDialog()
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 300, backgroundColor = 0xFFF0EAE2)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        LazyColumn {
            item { SamePaddingComponent() }
            item { CustomPaddingComponent() }
            item { OffsetComponent() }
         //   item { AspectRatioComponent() }
        }
    }

}

@Composable
fun SamePaddingComponent() {
    // Surface is a composable provided to fulfill the needs of the "Surface" metaphor from the
    // Material Design specification. It's generally used to change the background color, add
    // elevation, clip or add background shape to its children composables.
    Surface(color = Color.LightGray) {
        // The Text composable is pre-defined by the Compose UI library; you can use this
        // composable to render text on the screen
        Text(
            text = "This text has equal padding of 16dp in all directions",
            // You can think of Modifiers as implementations of the decorators pattern that are used to
            // modify the composable that its applied to. In this example, we assign a padding of
            // 16dp to the Text composable.
            modifier = Modifier.padding(16.dp),
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }
}

@Composable
fun CustomPaddingComponent() {
    // Surface is a composable provided to fulfill the needs of the "Surface" metaphor from the
    // Material Design specification. It's generally used to change the background color, add
    // elevation, clip or add background shape to its children composables.
    Surface(color = Color.Gray) {
        // The Text composable is pre-defined by the Compose UI library; you can use this
        // composable to render text on the screen
        Text(
            text = "This text has 32dp start padding, 4dp end padding, 32dp top padding & 0dp " +
                    "bottom padding padding in each direction",
            // You can think of Modifiers as implementations of the decorators pattern that are used to
            // modify the composable that its applied to. In this example, we assign variable
            // padding to the Text composable.
            modifier = Modifier.padding(start = 32.dp, end = 4.dp, top = 32.dp, bottom = 0.dp),
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }

    @Composable
    fun OffsetComponent() {
        // Surface is a composable provided to fulfill the needs of the "Surface" metaphor from the
        // Material Design specification. It's generally used to change the background color, add
        // elevation, clip or add background shape to its children composables.

        // You can think of Modifiers as implementations of the decorators pattern that are used to
        // modify the composable that its applied to. In this example, we make use of the
        // Modifier.offset modifier that allows the composable to be shifted along the x & y direction
        // by the user specified amount.
        Surface(color = Color.Magenta, modifier = Modifier.offset(x = 8.dp, y = 8.dp)) {
            // The Text composable is pre-defined by the Compose UI library; you can use this
            // composable to render text on the screen
            Text(
                text = "This text is using an offset of 8 dp instead of padding. Padding also ends up" +
                        " modifying the size of the layout. Using offset instead ensures that the " +
                        "size of the layout retains its size.",
                style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
            )
        }
    }

}
@Composable
fun OffsetComponent() {
    // Surface is a composable provided to fulfill the needs of the "Surface" metaphor from the
    // Material Design specification. It's generally used to change the background color, add
    // elevation, clip or add background shape to its children composables.

    // You can think of Modifiers as implementations of the decorators pattern that are used to
    // modify the composable that its applied to. In this example, we make use of the
    // Modifier.offset modifier that allows the composable to be shifted along the x & y direction
    // by the user specified amount.
    Surface(color =Color.Blue, modifier = Modifier.offset(x = 8.dp, y = 8.dp)) {
        // The Text composable is pre-defined by the Compose UI library; you can use this
        // composable to render text on the screen
        Text(
            text = "This text is using an offset of 8 dp instead of padding. Padding also ends up" +
                    " modifying the size of the layout. Using offset instead ensures that the " +
                    "size of the layout retains its size.",
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }
}

