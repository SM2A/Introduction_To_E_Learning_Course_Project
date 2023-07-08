package com.example.tsl.model.content

import com.example.tsl.model.ExamItem

object RememberExam : Exam() {
    override val title = "آزمون سنجش یادگیری"

    override val examContent: List<ExamItem>
        get() = TODO("Not yet implemented")
}