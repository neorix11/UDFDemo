package com.bluelampcreative.domain.models

sealed class Outcome <out T> {
    data class Success<out T>(val value: T) : Outcome<T>()
    data class Error(val error: Any) : Outcome<Nothing>()

    companion object {
        inline fun <T> tryBlock(block: () -> T): Outcome<T> = try {
            Success(block())
        } catch (e: Exception) {
            Error(e)
        }
    }
}