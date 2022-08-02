package com.bluelampcreative.udfdemo.ui.views.moviesearch

import com.bluelampcreative.udfdemo.ui.state.ExpandedListState
import com.bluelampcreative.udfdemo.ui.state.LoadingState

fun movieSearchReducer(currentState: MovieSearchViewState, action: Any): MovieSearchViewState {
    return when (action) {
        is MovieSearchViewActions.SetMovieSearchResults -> {
            currentState.copy(
                loadingState = LoadingState.Loaded,
                searchResults = action.results
            )
        }
        is MovieSearchViewActions.SetLoadingState -> {
            currentState.copy(loadingState = action.loadingState)
        }
        is MovieSearchViewActions.ShowMoreListings -> {
            currentState.copy(expandableListState = ExpandedListState.Expanded)
        }
        else -> currentState
    }
}