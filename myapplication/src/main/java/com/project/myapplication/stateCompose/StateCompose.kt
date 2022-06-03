package com.project.myapplication.stateCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.project.myapplication.ui.theme.MyApplicationTheme

class StateCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme() {

            }
        }
    }
}
@Preview(showBackground = true, widthDp = 500, heightDp = 500, backgroundColor = 0xFFF0EAE2)
@Composable
fun StateComposablePreview() {

}