package com.bluelampcreative.udfdemo.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MovieListImage(posterPath: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://image.tmdb.org/t/p/w500$posterPath")
            .size(200)
            .crossfade(true)
            .build(),
        contentDescription = "Movie Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.clip(RoundedCornerShape(10.dp))
    )
}