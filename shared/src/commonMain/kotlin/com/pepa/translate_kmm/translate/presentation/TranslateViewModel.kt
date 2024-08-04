package com.pepa.translate_kmm.translate.presentation

import com.pepa.translate_kmm.core.domain.history.HistoryDataSource
import kotlinx.coroutines.CoroutineScope

class TranslateViewModel(
    private val translate: TranslateEvent.Translate,
    private val historyDataSource: HistoryDataSource,
    private val coroutineScope: CoroutineScope?
) {

}