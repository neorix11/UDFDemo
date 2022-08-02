package com.bluelampcreative.data.repositories

import com.bluelampcreative.domain.models.MovieSearchResponse
import com.bluelampcreative.domain.models.Outcome
import com.bluelampcreative.domain.repositories.IMovieRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class MovieRepository(private val client: HttpClient): IMovieRepository {

    private val baseUrl = "https://api.themoviedb.org/3"

    override suspend fun fetchMovieSearch(queryString: String): Outcome<MovieSearchResponse> {
        return Outcome.tryBlock {
            client.get("$baseUrl/search/movie") {
                parameter("query", queryString)
                parameter("api_key", "392769cae8cb43b9e9b953eb0cec86bf")
            }.body()
        }
    }
}