package com.demo.composables.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bluelampcreative.domain.models.Movie
import com.demo.composables.R

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