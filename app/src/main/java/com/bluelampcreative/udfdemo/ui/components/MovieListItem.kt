package com.demo.composables.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bluelampcreative.domain.models.Movie
import com.bluelampcreative.udfdemo.ui.components.MovieListImage

@Composable
fun MovieListItem(
    movieData: Movie,
    onClick: (movieId: Int) -> Unit
){
    Card(
        Modifier
            .padding(4.dp)
            .fillMaxWidth(),
    elevation = 4.dp) {
        Row(Modifier.clickable { onClick(movieData.id) }) {
            MovieListImage(posterPath = movieData.posterPath)
            Column(Modifier
                .padding(8.dp)
            ) {
                Text(movieData.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(movieData.releaseDate)
            }
        }
    }
}