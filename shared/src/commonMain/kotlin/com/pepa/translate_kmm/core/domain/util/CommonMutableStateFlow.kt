package com.pepa.translate_kmm.core.domain.util

import kotlinx.coroutines.flow.MutableStateFlow

expect class CommonMutableStateFlow<T>(mutableStateFlow: MutableStateFlow<T>): MutableStateFlow<T>

fun <T> MutableStateFlow<T>.toCommonMutableStateFlow() = CommonMutableStateFlow(this)