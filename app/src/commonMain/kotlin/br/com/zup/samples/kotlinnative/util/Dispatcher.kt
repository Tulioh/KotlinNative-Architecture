package br.com.zup.samples.kotlinnative.util

import kotlinx.coroutines.CoroutineDispatcher

expect fun getMainDispetcher(): CoroutineDispatcher

expect fun <T> runTest(block: suspend () -> T)