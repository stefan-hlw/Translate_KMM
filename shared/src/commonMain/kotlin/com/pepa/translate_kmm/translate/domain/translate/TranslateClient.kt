package com.pepa.translate_kmm.translate.domain.translate

import com.pepa.translate_kmm.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}