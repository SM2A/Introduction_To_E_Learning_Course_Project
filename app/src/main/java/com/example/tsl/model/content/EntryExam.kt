package com.example.tsl.model.content

import com.example.tsl.R
import com.example.tsl.model.ExamItem

object EntryExam : Exam() {

    override val title = "آزمون ورودی"

    override val examContent = listOf(
        ExamItem(
            image = R.drawable.danger,
            question = "تابلو بالا، چه تابلویی است ؟",
            answers = mapOf(
                "خطر" to true,
                "نزدیک شدن به میدان" to false,
                "نزدیک شدن به چراغ راهنمایی" to false,
                "محدودیت سرعت" to false
            )
        ),
        ExamItem(
            image = R.drawable.traffic_sign,
            question = "تابلو بالا، چه تابلویی است ؟",
            answers = mapOf(
                "نزدیک شدن به چراغ راهنمایی" to true,
                "عبور از چراغ قرمز مجاز است" to false,
                "هشدار" to false,
                "راهنما مسیر" to false
            )
        ),
        ExamItem(
            image = R.drawable.pedestrian_crossing_cross_mark,
            question = "تابلو بالا، چه تابلویی است ؟",
            answers = mapOf(
                "محل عبور عابر پیاده" to true,
                "خطر تصادف با عابر پیاده" to false,
                "هشدار" to false,
                "راهنما مسیر" to false
            )
        ),
        ExamItem(
            image = R.drawable.highway_sign,
            question = "تابلو بالا، چه تابلویی است ؟",
            answers = mapOf(
                "بزرگ راه" to true,
                "آزاد راه" to false,
                "کوچه" to false,
                "ورود به جازه ممنوع" to false
            )
        ),
        ExamItem(
            image = R.drawable.no_bicycle,
            question = "تابلو بالا، چه تابلویی است ؟",
            answers = mapOf(
                "عبور دوچرخه ممنوع" to true,
                "ورودی دوچرخه" to false,
                "تنها ورود دوچرخه مجاز" to false,
                "خطر عبور دوچرخه" to false
            )
        ),
        ExamItem(
            image = R.drawable.speed_limit_80,
            question = "تابلو بالا، چه تابلویی است ؟",
            answers = mapOf(
                "محدودیت حداکثر سرعت ۸۰" to true,
                "محدودیت حداقل سرعت ۸۰" to false,
                "عرض جاده ۸۰ متر" to false,
                "طول جاده ۸۰ متر" to false
            )
        ),
        ExamItem(
            image = R.drawable.yield,
            question = "تابلو بالا، چه تابلویی است ؟",
            answers = mapOf(
                "رعایت حق تقدم" to true,
                "خطری نیست" to false,
                "برداشته شدن تمام محدودیت ها" to false,
                "بودن چراغ راهنمایی" to false
            )
        ),
        ExamItem(
            image = R.drawable.gas_station,
            question = "تابلو بالا، چه تابلویی است ؟",
            answers = mapOf(
                "جایگاه سوخت" to true,
                "عدم وجود جایگاه سوخت" to false,
                "خطر وجود سوخت در مسیر" to false,
                "پیشنهاد سوخت گیری" to false
            )
        )
    )
}
