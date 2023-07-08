package com.example.tsl.model.content

import com.example.tsl.model.ExamItem
import com.example.tsl.model.LessonItem

object RoadGuideSigns : Lesson() {

    override val title = "تابلوهای راهنما مسیر"

    override val intro = ""

    override val lessonContent: List<LessonItem> = emptyList()

    override val exam: ExamItem
        get() = TODO("Not yet implemented")
}