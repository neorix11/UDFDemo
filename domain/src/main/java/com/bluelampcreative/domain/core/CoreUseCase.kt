package com.bluelampcreative.domain.core

interface IUseCase<in Params, out T> {
    suspend fun execute(params: Params): T
}

abstract class CoreUseCase<in Params, out T> : IUseCase<Params, T> {
    suspend operator fun invoke(params: Params): T = execute(params)
}