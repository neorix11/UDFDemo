package com.bluelampcreative.udfdemo.ui.views.moviesearch

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.bluelampcreative.domain.models.Movie
import com.bluelampcreative.udfdemo.ui.components.LoadMoreButton
import com.bluelampcreative.udfdemo.ui.state.LoadingState
import com.bluelampcreative.udfdemo.ui.components.MovieDisplayList
import com.bluelampcreative.udfdemo.ui.components.MovieSearchBar
import com.bluelampcreative.udfdemo.ui.state.ExpandedListState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.compose.inject

@ExperimentalCoroutinesApi
@Composable
fun MovieSearchView(
    movieSelected: (movie: Movie) -> Unit
) {

    val viewModel: MovieSearchViewModel by inject()
    val context = LocalContext.current
    val state = viewModel.state.collectAsState()


    Column {
        MovieSearchBar{ searchTerm ->
            viewModel.fetchData(searchTerm)
        }
        when(state.value.loadingState) {
            is LoadingState.Error -> {
                Toast.makeText(
                    context,
                    "There was an error: ${state.value.error}",
                    Toast.LENGTH_SHORT)
                    .show()
            }
            is LoadingState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } is LoadingState.Loaded -> {
                MovieDisplayList(
                    state.value.searchResults,
                    state.value.expandableListState
                ) { movie ->
                    movieSelected(movie)
                }
                if(state.value.expandableListState is ExpandedListState.Limited) {
                    LoadMoreButton{ viewModel.showMoreListings() }
                }
            }
            else -> {
                Text(
                    modifier = Modifier.align(CenterHorizontally),
                    text = "Search for a Movie")
            }
        }
    }
}