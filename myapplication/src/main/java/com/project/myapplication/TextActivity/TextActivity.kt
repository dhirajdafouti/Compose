package com.project.myapplication.TextActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.project.myapplication.ui.theme.MyApplicationTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme() {

            }
        }
    }

}

@Preview(showBackground = true, widthDp = 300, heightDp = 300, backgroundColor = 0xFFF0EAE2)
@Composable
fun TextComposablePreview() {
    TextCompose()
}

@Composable
fun TextCompose() {
    var scollState = rememberScrollState()
    Column() {

    }
}
