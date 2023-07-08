package com.example.tsl.model.content

import com.example.tsl.model.ExamItem
import com.example.tsl.model.LessonItem

abstract class ContentType {
    abstract val title: String
}

abstract class Lesson : ContentType() {
    abstract val intro: String
    abstract val lessonContent: List<LessonItem>
    abstract val exam: ExamItem
}

abstract class Exam : ContentType() {
    abstract val examContent: List<ExamItem>
}
