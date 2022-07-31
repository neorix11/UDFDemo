package com.bluelampcreative.udfdemo.ui.views.moviesearch

import androidx.lifecycle.viewModelScope
import com.bluelampcreative.domain.models.Movie
import com.bluelampcreative.domain.models.Outcome
import com.bluelampcreative.domain.usecases.MovieSearchUC
import com.bluelampcreative.udfdemo.core.BaseViewModel
import com.bluelampcreative.udfdemo.core.reducer
import com.bluelampcreative.udfdemo.ui.state.LoadingState
import kotlinx.coroutines.launch

class MovieSearchViewModel(
    private val movieSearch: MovieSearchUC
): BaseViewModel<MovieSearchViewState>() {

    override val state = reducer(
        initialState = MovieSearchViewState(),
        reduceState = ::reduceState
    )

    override fun reduceState(currentState: MovieSearchViewState, action: Any): MovieSearchViewState {
        return when(action) {
            is MovieSearchViewAction.UpdateMovieSearchResults -> {
                currentState.copy(
                    loadingState = LoadingState.Loaded,
                    searchResults = action.results
                )
            }
            is MovieSearchViewAction.SetLoadingState -> {
                currentState.copy(loadingState = action.loadingState)
            }
            else -> currentState
        }
    }

    fun fetchData(queryString: String) {
        state.handleAction(MovieSearchViewAction.SetLoadingState(LoadingState.Loading))
        viewModelScope.launch {
            when(val response = movieSearch(queryString)) {
                is Outcome.Success -> {
                    state.handleAction(MovieSearchViewAction.UpdateMovieSearchResults(response.value.results))
                }
                is Outcome.Error -> {
                    println("THERE WAS AN ERROR")
                }
            }
        }
    }



    sealed class MovieSearchViewAction {
        class UpdateMovieSearchResults(val results: List<Movie>)
        class SetLoadingState(val loadingState: LoadingState)
    }
}