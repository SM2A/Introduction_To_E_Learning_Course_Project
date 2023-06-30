package com.example.tsl.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.example.tsl.model.content.Lesson
import com.example.tsl.util.getDataFromName

class LessonActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val data = getDataFromName(intent.getStringExtra("className")) as Lesson
            Text(text = "Lesson ${data.title}")
        }
    }

}
