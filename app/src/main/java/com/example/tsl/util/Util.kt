package com.example.tsl.util

import android.content.Context
import com.example.tsl.model.content.*

fun getDataFromName(name: String?) =
    when (name) {
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

private const val PREF_NAME = "TSL_PREF"

fun Context.savePreference(key: String, value: String) {
    val pref = this.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    with(pref.edit()) {
        putString(key, value)
        apply()
    }
}

fun Context.getStringPreference(key: String): String? {
    val pref = this.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    return pref.getString(key, null)
}

fun Context.savePreference(key: String, value: Boolean) {
    val pref = this.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    with(pref.edit()) {
        putBoolean(key, value)
        apply()
    }
}

fun Context.getBooleanPreference(key: String): Boolean {
    val pref = this.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    return pref.getBoolean(key, false)
}

fun Context.savePreference(key: String, value: Int) {
    val pref = this.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    with(pref.edit()) {
        putInt(key, value)
        apply()
    }
}

fun Context.getIntPreference(key: String): Int {
    val pref = this.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    return pref.getInt(key, -1)
}

fun Context.savePreference(key: String, value: Set<String>) {
    val pref = this.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    with(pref.edit()) {
        putStringSet(key, value)
        apply()
    }
}

fun Context.getStringSetPreference(key: String): Set<String> {
    val pref = this.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    return pref.getStringSet(key, emptySet()) ?: setOf()
}
