package com.example.tsl.model.content

abstract class ContentType {
    abstract val title: String
}

abstract class Lesson : ContentType()

abstract class Exam : ContentType()
