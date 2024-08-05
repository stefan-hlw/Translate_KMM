package com.pepa.translate_kmm.translate.presentation

import com.pepa.translate_kmm.core.presentation.UiLanguage

class UiHistoryItem(
    val id: Long,
    val fromText: String,
    val toText: String,
    val fromLanguage: UiLanguage,
    val toLanguage: UiLanguage
)