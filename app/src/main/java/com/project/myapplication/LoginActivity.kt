package com.project.myapplication

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.myapplication.ui.theme.MyApplicationTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            MyApplicationTheme() {
                checkRow()
            }
        }
    }

    @Composable
    private fun checkRow() {
        Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Hello",color = MaterialTheme.colors.primary)
            Text(text = "India",color = MaterialTheme.colors.primary)
        }
    }



    @Preview(showBackground = true, widthDp = 320, heightDp = 320)
    @Composable
    fun OnboardingPreview() {
        MyApplicationTheme {
           //checkRow()
        }
    }

}