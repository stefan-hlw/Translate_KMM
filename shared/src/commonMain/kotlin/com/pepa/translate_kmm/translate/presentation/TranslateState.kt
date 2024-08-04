package com.pepa.translate_kmm.translate.presentation

import com.pepa.translate_kmm.core.presentation.UiLanguage
import com.pepa.translate_kmm.translate.domain.translate.TranslateError

data class TranslateState(
    val fromText: String = "",
    val toText: String? = null,
    val isTranslating: Boolean = false,
    val fromLanguage: UiLanguage = UiLanguage.byCode("en"),
    val toLanguage: UiLanguage = UiLanguage.byCode("it"),
    val isChoosingFromLanguage: Boolean = false,
    val isChoosingToLanguage: Boolean = false,
    val errors: TranslateError? = null,
    val history: List<UiHistoryItem> = emptyList()
)
