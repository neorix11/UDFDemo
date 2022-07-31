package com.demo.composables.components

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.bluelampcreative.domain.models.Movie
import com.demo.data.core.LoadingState

@Composable
fun MovieDisplayList(
    movies: List<Movie>,
    onMovieSelect: (movie: Movie) -> Unit
) {
    LazyColumn(content = {
            items(
                items = movies,
                key = { movie -> movie.id}
            ) { item ->
                MovieListItem(movieData = item) {
                    onMovieSelect(item)
                }
            }
    })
}