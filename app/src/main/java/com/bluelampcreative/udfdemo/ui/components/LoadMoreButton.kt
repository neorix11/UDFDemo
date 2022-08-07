package com.bluelampcreative.udfdemo.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoadMoreButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { onClick() }) {
            Text(text = "Show More")
        }
    }
}