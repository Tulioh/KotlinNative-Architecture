package br.com.zup.samples.kotlinnative.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

actual fun getMainDispetcher(): CoroutineDispatcher {
    return Dispatchers.Main
}

actual fun <T> runTest(block: suspend () -> T) {
    runBlocking { block() }
}