package com.example.tsl.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import com.example.tsl.model.content.Lesson
import com.example.tsl.util.getDataFromName
import com.example.tsl.viewmodel.LessonViewModel

class LessonActivity : ComponentActivity() {

    private val viewModel: LessonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val data = getDataFromName(intent.getStringExtra("className")) as Lesson
            Text(text = "Lesson ${data.title}")
        }
    }

}
