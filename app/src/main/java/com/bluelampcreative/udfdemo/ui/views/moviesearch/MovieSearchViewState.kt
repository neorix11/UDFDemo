package com.bluelampcreative.udfdemo.ui.views.moviesearch

import com.bluelampcreative.domain.models.Movie
import com.bluelampcreative.udfdemo.ui.state.LoadingState

data class MovieSearchViewState(
    val queryString: String = "",
    val searchResults: List<Movie> = emptyList(),
    val loadingState: LoadingState = LoadingState.Idle,
    val error: String = ""
)