package br.com.zup.samples.kotlinnative.base

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

open class BaseViewModel {

    private val jobs = ArrayList<Job>()

    protected fun launch(context: CoroutineContext, onError: (Throwable) -> Unit, function: suspend () -> Unit) {
        jobs.add(GlobalScope.launch(context) {
            try {
                function()
            } catch (e: Throwable) {
                onError(e)
            }
        })
    }

    fun onCleared() {
        jobs.forEach { if(!it.isCancelled) it.cancel() }
    }

}