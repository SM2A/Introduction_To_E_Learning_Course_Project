package com.example.tsl.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tsl.model.content.Exam
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor() : ViewModel() {

    lateinit var data: Exam

    private val itemIndexMutable = MutableStateFlow(0)
    val itemIndex: StateFlow<Int> = itemIndexMutable

    fun nextItem() {
        if (itemIndex.value < data.examContent.size) itemIndexMutable.value = (itemIndexMutable.value + 1)
    }

    fun getItem() = data.examContent[itemIndexMutable.value]
}