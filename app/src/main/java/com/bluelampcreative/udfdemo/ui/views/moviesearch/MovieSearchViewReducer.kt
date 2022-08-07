package com.bluelampcreative.udfdemo.ui.views.moviesearch

import com.bluelampcreative.udfdemo.ui.state.ExpandedListState
import com.bluelampcreative.udfdemo.ui.state.LoadingState

fun movieSearchReducer(currentState: MovieSearchViewState, action: Any): MovieSearchViewState {
    return when (action) {
        is MovieSearchViewActions.SetMovieSearchResults -> handleSetMovieSearchResults(currentState, action)
        is MovieSearchViewActions.SetLoadingState -> {
            currentState.copy(loadingState = action.loadingState)
        }
        is MovieSearchViewActions.ShowMoreListings -> {
            currentState.copy(expandableListState = ExpandedListState.Expanded)
        }
        is MovieSearchViewActions.SetRequestError -> {
            currentState.copy(error = "Network Error")
        }
        else -> currentState
    }
}


private fun handleSetMovieSearchResults(
    currentState: MovieSearchViewState,
    action: MovieSearchViewActions.SetMovieSearchResults
): MovieSearchViewState {
    return currentState.copy(
        loadingState = LoadingState.Loaded,
        searchResults = action.results,
        expandableListState = if(action.results.size > 3) {
            ExpandedListState.Limited(3)
        } else {
            ExpandedListState.Expanded
        }
    )
}