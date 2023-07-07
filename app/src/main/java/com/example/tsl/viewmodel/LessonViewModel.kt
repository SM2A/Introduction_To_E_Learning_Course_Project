package com.example.tsl.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tsl.model.content.Lesson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LessonViewModel @Inject constructor() : ViewModel() {

    lateinit var data: Lesson

//    private val itemIndexMutable = MutableLiveData(0)
//    val itemIndex: LiveData<Int> = itemIndexMutable

    var itemIndex = -1
        private set

    fun nextItem() {
//        itemIndexMutable.value = itemIndexMutable.value?.plus(1)
        if (itemIndex < (data.lessonContent.size - 1)) itemIndex++
    }

    fun previousItem() {
//        itemIndexMutable.value = itemIndexMutable.value?.minus(1)
        if (itemIndex >= 0) itemIndex--
    }

    fun getItem() = data.lessonContent[itemIndex]
}