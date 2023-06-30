package com.example.tsl.util

import com.example.tsl.model.content.*

fun getDataFromName(name: String?) =
    when(name) {
        "EntryExam" -> EntryExam
        "CautionarySigns" -> CautionarySigns
        "IndicativeSigns" -> IndicativeSigns
        "DeterrentSigns" -> DeterrentSigns
        "RoadGuideSigns" -> RoadGuideSigns
        "DomesticSigns" -> DomesticSigns
        "ComplimentarySigns" -> ComplimentarySigns
        "Labels" -> Labels
        "FinalExam" -> FinalExam
        "RememberExam" -> RememberExam
        else -> EntryExam
    }
