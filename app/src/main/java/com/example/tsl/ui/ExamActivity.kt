package com.example.tsl.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.example.tsl.model.content.Exam
import com.example.tsl.util.getDataFromName

class ExamActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val data = getDataFromName(intent.getStringExtra("className")) as Exam
            Text(text = "Exam ${data.title}")
        }
    }

}
