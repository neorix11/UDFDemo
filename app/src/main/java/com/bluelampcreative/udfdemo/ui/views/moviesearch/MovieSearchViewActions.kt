package com.bluelampcreative.udfdemo.ui.views.moviesearch

import com.bluelampcreative.domain.models.Movie
import com.bluelampcreative.udfdemo.ui.state.LoadingState

sealed class MovieSearchViewActions {
    class SetMovieSearchResults(val results: List<Movie>)
    class SetLoadingState(val loadingState: LoadingState)
    class ShowMoreListings(val shouldShowAll: Boolean, val limit: Int?)
    class SetRequestError(val error: String)
}
