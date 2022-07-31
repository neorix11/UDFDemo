package com.bluelampcreative.domain.usecases

import com.bluelampcreative.domain.core.CoreUseCase
import com.bluelampcreative.domain.models.MovieSearchResponse
import com.bluelampcreative.domain.models.Outcome
import com.bluelampcreative.domain.repositories.IMovieRepository
import kotlin.coroutines.CoroutineContext

class MovieSearchUC(
    private val movieRepository: IMovieRepository
): CoreUseCase<String, Outcome<MovieSearchResponse>>() {
    override suspend fun execute(params: String) = movieRepository.fetchMovieSearch(params)
}