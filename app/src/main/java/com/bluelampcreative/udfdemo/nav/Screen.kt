package com.bluelampcreative.udfdemo.nav

sealed class Screen(val title: String) {
    object MovieSearch: Screen("MovieSearch")
    object MovieDetail: Screen("MovieDetail")
    object WatchList: Screen("WatchList")
}