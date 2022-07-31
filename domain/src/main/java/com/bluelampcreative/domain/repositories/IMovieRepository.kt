package com.bluelampcreative.domain.repositories

import com.bluelampcreative.domain.models.MovieSearchResponse
import com.bluelampcreative.domain.models.Outcome

interface IMovieRepository {
    suspend fun fetchMovieSearch(queryString: String): Outcome<MovieSearchResponse>
}