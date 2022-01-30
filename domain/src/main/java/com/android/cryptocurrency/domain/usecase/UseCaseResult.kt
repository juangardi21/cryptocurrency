package com.android.cryptocurrency.domain.usecase

sealed class UseCaseResult<out Type> {

    data class Success<out Type>(
        val data: Type
    ) : UseCaseResult<Type>()

    data class Failure<out Type>(
        val throwable: Throwable
    ) : UseCaseResult<Type>()

    val isSuccess get() = this is Success
    val isFailure get() = this is Failure

    fun peekSuccessOrNull() : Type? {
        return when(this) {
            is Success -> this.data
            else -> null
        }
    }

    fun peekFailureOrNull() : Throwable? {
        return when(this) {
            is Failure -> this.throwable
            else -> null
        }
    }
}