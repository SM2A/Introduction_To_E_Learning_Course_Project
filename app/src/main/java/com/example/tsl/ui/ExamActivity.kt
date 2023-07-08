package com.example.tsl.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.tsl.BuildConfig
import com.example.tsl.model.ExamCallback
import com.example.tsl.model.content.Exam
import com.example.tsl.util.getDataFromName
import com.example.tsl.util.getIntPreference
import com.example.tsl.util.getStringSetPreference
import com.example.tsl.util.savePreference
import com.example.tsl.viewmodel.ExamViewModel

class ExamActivity : ComponentActivity() {

    private val viewModel: ExamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.data = getDataFromName(intent.getStringExtra("className")) as Exam

        if ((viewModel.data::class.java.simpleName in this.getStringSetPreference("LESSON_DONE"))
            && !BuildConfig.DEBUG
        ) {
            Toast.makeText(
                this,
                "قبلا این آزمون رو انجام دادی\r\nنمره شما: ${
                    applicationContext.getIntPreference(viewModel.data::class.java.simpleName)
                } از 100",
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }

        setContent {
            val index = viewModel.itemIndex.collectAsState()

            val hasNextItem = index.value < viewModel.data.examContent.size

            if (hasNextItem) {
                val correctAnswer = viewModel.getItem().answers.toList().first { it.second }.first
                ExamView(
                    modifier = Modifier
                        .fillMaxSize(),
                    item = viewModel.getItem(),
                    callback = object : ExamCallback {
                        override fun onCorrectItemSelected() {
                            Toast.makeText(this@ExamActivity, "آفرین درست بود", Toast.LENGTH_SHORT)
                                .show()
                            viewModel.correctAnswer()
                            viewModel.nextItem()
                        }

                        override fun onWrongItemSelected() {
                            Toast.makeText(
                                this@ExamActivity,
                                "اشتباه زدی\r\nگزینه درست: $correctAnswer",
                                Toast.LENGTH_SHORT
                            ).show()
                            viewModel.nextItem()
                        }
                    }
                )
            } else {
                val done = applicationContext.getStringSetPreference("LESSON_DONE").toMutableSet()
                done.add(viewModel.data::class.java.simpleName)
                applicationContext.savePreference("LESSON_DONE", done)

                applicationContext.savePreference(viewModel.data::class.java.simpleName, viewModel.getScore())
                Toast.makeText(this, "نمره شما: ${viewModel.getScore()} از 100", Toast.LENGTH_LONG).show()

                finish()
            }
        }
    }

}
