package com.example.tsl.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tsl.model.content.Lesson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LessonViewModel @Inject constructor() : ViewModel() {

    lateinit var data: Lesson

    private val itemIndexMutable = MutableStateFlow(-1)
    val itemIndex: StateFlow<Int> = itemIndexMutable

    fun nextItem() {
        if (itemIndex.value < (data.lessonContent.size - 1)) itemIndexMutable.value = (itemIndexMutable.value + 1)
    }

    fun previousItem() {
        if (itemIndexMutable.value >= 0) itemIndexMutable.value = (itemIndexMutable.value - 1)
    }

    fun getItem() = data.lessonContent[itemIndexMutable.value]
}