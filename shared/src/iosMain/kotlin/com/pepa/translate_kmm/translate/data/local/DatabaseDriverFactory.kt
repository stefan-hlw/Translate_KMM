package com.pepa.translate_kmm.translate.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.pepa.translate_kmm.database.TranslateDatabase

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(TranslateDatabase.Schema, "translate.db")
    }
}