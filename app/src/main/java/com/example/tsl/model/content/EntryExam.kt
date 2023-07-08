package com.example.tsl.model.content

import com.example.tsl.R
import com.example.tsl.model.ExamItem

object EntryExam : Exam() {

    override val title = "آزمون ورودی"

    override val examContent = listOf(
        ExamItem(
            image = R.drawable.danger,
            question = "این چه تابلوییه ؟",
            answers = mapOf("خطر" to true, "میدون" to false, "چراغ" to false, "سرعت" to false)
        ),
        ExamItem(
            image = R.drawable.roundabout,
            question = "این چه تابلوییه ؟",
            answers = mapOf("خطر" to false, "میدون" to true, "جاده دو طرف" to false, "کوه" to false)
        )
    )
}
