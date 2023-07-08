package com.example.tsl.model.content

import com.example.tsl.model.ExamItem

object FinalExam : Exam() {
    override val title = "آزمون نهایی"

    override val examContent: List<ExamItem>
        get() = TODO("Not yet implemented")
}