package com.android.cryptocurrency.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseUseCase<out Type, in Params> {

    protected abstract suspend fun call(params: Params): Type

    suspend fun execute(params: Params): UseCaseResult<Type> =
        withContext(Dispatchers.IO) {
            try {
                UseCaseResult.Success(call(params))
            } catch (throwable: Throwable) {
                UseCaseResult.Failure(throwable)
            }
        }
}