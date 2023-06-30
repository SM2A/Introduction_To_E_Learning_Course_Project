package com.example.tsl.model.content

import com.example.tsl.R
import com.example.tsl.model.LessonItem

object CautionarySigns : Lesson() {

    override val title = "تابلوهای هشدار دهنده (اخطاری)"

    override val lessonContent: List<LessonItem> = listOf(
        LessonItem(
            image = R.drawable.danger,
            description = "تابلو خطر"
        )
    )

}