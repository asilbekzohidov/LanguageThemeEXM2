package com.example.languagethemeexm.utils

import android.app.Activity
import android.content.res.Configuration
import com.example.examplelanguagetheme.utils.SharedPref
import java.util.*

fun languageUpdate(requireActivity: Activity, language: String) {
    val locale = Locale(language)
    Locale.setDefault(locale)
    val config = Configuration()
    config.locale = locale
    requireActivity.resources.updateConfiguration(config, requireActivity.resources.displayMetrics)
    SharedPref.changLanguage(requireActivity, language)
}