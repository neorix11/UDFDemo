package com.bluelampcreative.udfdemo.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigation(
    val route: String,
    val icon: ImageVector,
    val iconDescription: String
)

val bottomNavigationItems = listOf(
    BottomNavigation(
        Screen.MovieSearch.title,
        Icons.Default.Search,
        "Search"
    ),
    BottomNavigation(
        Screen.WatchList.title,
        Icons.Outlined.PlayArrow,
        "Watch List"
    )
)