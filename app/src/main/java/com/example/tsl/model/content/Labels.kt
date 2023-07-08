package com.example.tsl.model.content

import com.example.tsl.model.ExamItem
import com.example.tsl.model.LessonItem

object Labels : Lesson() {

    override val title = "برچسب ها"

    override val intro = ""

    override val lessonContent: List<LessonItem> = emptyList()

    override val exam: ExamItem
        get() = TODO("Not yet implemented")
}