package com.example.tsl.model.content

import com.example.tsl.R
import com.example.tsl.model.LessonItem

object CautionarySigns : Lesson() {

    override val title = "تابلوهای هشدار دهنده (اخطاری)"

    override val intro = "در این بخش میخوایم در مورد تایلو های هشداری توضیح بدیم"

    override val lessonContent: List<LessonItem> = listOf(
        LessonItem(
            image = R.drawable.danger,
            description = "تابلو خطر"
        ),
        LessonItem(
            image = R.drawable.uneven,
            description = "تابلو نزدیک شدن به دست انداز"
        ),
        LessonItem(
            image = R.drawable.narrow_road,
            description = "تابلو جاده باریک"
        ),
        LessonItem(
            image = R.drawable.pedestrian_crossing,
            description = "تابلو عبور عابر پیاده"
        ),
        LessonItem(
            image = R.drawable.roundabout,
            description = "تابلو نزدیک شدن به میدان"
        ),
        LessonItem(
            image = R.drawable.two_way_street,
            description = "تابلو جاده دو طرفه"
        )
    )

}