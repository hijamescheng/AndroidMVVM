package com.james.core.util

import com.james.core.util.ResultStatus.SUCCESS
import com.james.core.util.ResultStatus.ERROR
import com.james.core.util.ResultStatus.LOADING

data class Result<out T>(
    val status: ResultStatus,
    val data: T? = null,
    val exception: Throwable? = null
) {

    companion object {
        fun <T> isSuccessful(data: T?): Result<T> {
            return Result(status = SUCCESS, data = data)
        }

        fun <T> isError(exception: Throwable?): Result<T> {
            return Result(status = ERROR, exception = exception)
        }

        fun <T> isLoading(): Result<T> {
            return Result(status = LOADING)
        }
    }

    fun isSuccessful() = status == SUCCESS
    fun isLoading() = status == LOADING
    fun isError() = status == ERROR
}

enum class ResultStatus {
    SUCCESS, ERROR, LOADING
}
