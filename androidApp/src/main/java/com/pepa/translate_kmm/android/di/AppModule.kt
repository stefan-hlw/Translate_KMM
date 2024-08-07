package com.pepa.translate_kmm.android.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import com.pepa.translate_kmm.core.domain.history.HistoryDataSource
import com.pepa.translate_kmm.database.TranslateDatabase
import com.pepa.translate_kmm.translate.data.history.SqlDelightHistoryDataSource
import com.pepa.translate_kmm.translate.data.local.DatabaseDriverFactory
import com.pepa.translate_kmm.translate.data.remote.HttpClientFactory
import com.pepa.translate_kmm.translate.data.translate.KtorTranslateClient
import com.pepa.translate_kmm.translate.domain.translate.TranslateClient
import com.pepa.translate_kmm.translate.domain.translate.TranslateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideTranslateClient(httpClient: HttpClient): TranslateClient {
        return KtorTranslateClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideDatabaseDriverFactory(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver): HistoryDataSource {
        return SqlDelightHistoryDataSource(TranslateDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(client: TranslateClient, dataSource: HistoryDataSource): TranslateUseCase {
        return TranslateUseCase(client, dataSource)
    }

}
