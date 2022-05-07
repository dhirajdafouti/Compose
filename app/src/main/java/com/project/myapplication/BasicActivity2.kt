package com.project.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.compose.setContent

class BasicActivity2 : androidx.activity.ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {

        }
    }


}