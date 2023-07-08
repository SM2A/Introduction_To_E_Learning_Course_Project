package com.example.tsl.model

data class ExamItem(
    val image: Int,
    val question: String,
    val answers: Map<String, Boolean>
)
