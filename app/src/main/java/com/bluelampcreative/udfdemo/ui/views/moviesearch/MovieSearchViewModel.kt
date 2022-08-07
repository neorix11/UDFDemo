package com.bluelampcreative.udfdemo.ui.views.moviesearch

import androidx.lifecycle.viewModelScope
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
        reducer = ::movieSearchReducer
    )

    fun fetchData(queryString: String) {
        state.dispatch(MovieSearchViewActions.SetLoadingState(LoadingState.Loading))
        viewModelScope.launch {
            when(val response = movieSearch(queryString)) {
                is Outcome.Success -> {
                    state.dispatch(MovieSearchViewActions.SetMovieSearchResults(response.value.results))
                }
                is Outcome.Error -> {
                    state.dispatch(MovieSearchViewActions.SetRequestError(response.error.toString()))
                }
            }
        }
    }

    fun showMoreListings() {
        state.dispatch(MovieSearchViewActions.ShowMoreListings(false, 10))
    }
}