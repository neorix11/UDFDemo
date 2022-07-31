package com.bluelampcreative.udfdemo.ui.views.moviesearch

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import com.demo.composables.components.MovieDisplayList
import com.demo.composables.components.MovieSearchBar
import org.koin.androidx.compose.viewModel

@Composable
fun MovieSearchView(
    movieSelected: (movie: Movie) -> Unit
) {

    val context = LocalContext.current

    val viewModel by viewModel<MovieSearchViewModel>()
    val state = viewModel.state.collectAsState()

    Column {
        MovieSearchBar{ searchTerm ->
            viewModel.fetchData(searchTerm)
        }
        if(state.value.loadingState is LoadingState.Error) {
            Toast.makeText(
                context,
                "There was an error: ${state.value.error}",
                Toast.LENGTH_SHORT)
                .show()
        } else {
            MovieDisplayList(state.value.searchResults) { movie ->
                movieSelected(movie)
            }
        }
    }

}