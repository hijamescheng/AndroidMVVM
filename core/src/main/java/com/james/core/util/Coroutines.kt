package com.james.core.util

import kotlinx.coroutines.*

object Coroutines {

    fun <T : Any> ioThenMain(
        work: suspend (() -> T?),
        loadingCallback: (() -> Unit)?,
        successCallback: ((T?) -> Unit)?,
        errorCallback: ((Exception) -> Unit)? = null
    ): Job = CoroutineScope(Dispatchers.Main).launch {
        try {
            loadingCallback?.invoke()
            val result = CoroutineScope(Dispatchers.IO).async {
                return@async work()
            }.await()
            successCallback?.invoke(result)
        } catch (e: Exception) {
            errorCallback?.invoke(e)
        }
    }
}