package com.example.tsl.model.content

import com.example.tsl.R
import com.example.tsl.model.ExamItem
import com.example.tsl.model.LessonItem

object CautionarySigns : Lesson() {

    override val title = "تابلوهای هشدار دهنده (اخطاری)"

    override val intro =
        "در این بخش قرار است در مورد تابلو های هشدار دهنده توضیح داده شود\r\nاین تابلو ها به شکل مثلث با حاشیه قرمز رنگ هستند"

    override val lessonContent: List<LessonItem> = listOf(
        LessonItem(
            image = R.drawable.danger,
            description = "تابلو خطر"
        ),
        LessonItem(
            image = R.drawable.uneven,
            description = "تابلو نزدیک شدن به دست انداز (سرعت گیر)"
        ),
        LessonItem(
            image = R.drawable.narrow_road,
            description = "تابلو جاده باریک می شود"
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
        ),
        LessonItem(
            image = R.drawable.falling_rocks,
            description = "تابلو هشدار سقوط سنگ"
        ),
        LessonItem(
            image = R.drawable.crossroads,
            description = "تابلو جاده مارپیچ اولین پیچ به چپ"
        ),
        LessonItem(
            image = R.drawable.bend,
            description = "تابلو تقاطع مسیر فرعی با اصلی"
        ),
        LessonItem(
            image = R.drawable.slippery_road,
            description = "تابلو جاده لغزنده"
        )
    )

    override val exam = ExamItem(
        image = R.drawable.turn_right_caution,
        question = "تابلو بالا چه تابلویی است ؟",
        answers = mapOf(
            "پیچ به راست" to true,
            "خطر نزدیک شدن به مار" to false,
            "راه از چپ باریک می شود" to false,
            "گردش به راست ممنوع" to false
        )
    )
}