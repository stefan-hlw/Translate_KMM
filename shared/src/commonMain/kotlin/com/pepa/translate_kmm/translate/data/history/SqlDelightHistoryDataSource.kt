package com.pepa.translate_kmm.translate.data.history

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.pepa.translate_kmm.core.domain.history.HistoryDataSource
import com.pepa.translate_kmm.core.domain.history.HistoryItem
import com.pepa.translate_kmm.core.domain.history.toHistoryItem
import com.pepa.translate_kmm.core.domain.util.CommonFlow
import com.pepa.translate_kmm.core.domain.util.toCommonFlow
import com.pepa.translate_kmm.database.TranslateDatabase
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlin.coroutines.CoroutineContext

class SqlDelightHistoryDataSource(
    db: TranslateDatabase
): HistoryDataSource {

    private val queries = db.translateQueries

    override fun getHistory(context: CoroutineContext): CommonFlow<List<HistoryItem>> {
        return queries
            .getHistory()
            .asFlow()
            .mapToList(context)
            .map { history ->
                history.map { item ->
                    item.toHistoryItem()
                }
            }
            .toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        queries.insertHistoryEntity(
            id = item.id,
            fromLanguageCode = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguageCode = item.toLanguageCode,
            toText = item.toText,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }

}