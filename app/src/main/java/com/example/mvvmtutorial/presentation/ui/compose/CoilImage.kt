package com.example.mvvmtutorial.presentation.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CoilImage( imageUrl: String) {
    Image(
        painter = rememberAsyncImagePainter(
            model = "https://image.tmdb.org/t/p/w600_and_h900_bestv2${imageUrl}",
            contentScale = ContentScale.Fit
        ),
        contentDescription = "Coil Image",
        modifier = Modifier
            .size(80.dp)
            .clip(RectangleShape)
    )

}