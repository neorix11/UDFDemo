package com.bluelampcreative.udfdemo.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bluelampcreative.domain.models.Movie
import com.bluelampcreative.udfdemo.ui.state.ExpandedListState
import com.demo.composables.components.MovieListItem

@Composable
fun MovieDisplayList(
    movies: List<Movie>,
    expandedList: ExpandedListState = ExpandedListState.Expanded,
    onMovieSelect: (movie: Movie) -> Unit
) {
    val listItems = if(expandedList is ExpandedListState.Limited) {
        movies.take(expandedList.items)
    } else {
        movies
    }

    LazyColumn(content = {
            items(
                items = listItems,
                key = { movie -> movie.id}
            ) { item ->
                MovieListItem(movieData = item) {
                    onMovieSelect(item)
                }
            }
    })
}