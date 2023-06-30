package com.example.tsl.model.content

import com.example.tsl.model.LessonItem

abstract class ContentType {
    abstract val title: String
}

abstract class Lesson : ContentType() {
    abstract val lessonContent: List<LessonItem>
}

abstract class Exam : ContentType()
