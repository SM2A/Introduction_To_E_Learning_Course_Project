package com.example.tsl.model.content

import com.example.tsl.model.ExamItem
import com.example.tsl.model.LessonItem

object ComplimentarySigns : Lesson() {

    override val title = "تابلوهای مکمل"

    override val intro = ""

    override val lessonContent: List<LessonItem> = emptyList()

    override val exam: ExamItem
        get() = TODO("Not yet implemented")
}