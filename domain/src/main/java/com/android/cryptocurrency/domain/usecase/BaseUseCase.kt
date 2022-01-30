package com.android.cryptocurrency.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

abstract class BaseUseCase<out Type, in Params> {

    protected abstract suspend fun call(params: Params): Type

    suspend fun execute(params: Params): Flow<UseCaseResult<Type>> =
        withContext(Dispatchers.IO) {
            flow {
                try {
                    emit(UseCaseResult.Success(call(params)))
                } catch (throwable: Throwable) {
                    emit(UseCaseResult.Failure(throwable))
                }
            }
        }
}