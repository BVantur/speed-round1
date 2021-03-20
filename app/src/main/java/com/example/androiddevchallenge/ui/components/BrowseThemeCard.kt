package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Theme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun ThemeCard(item: Theme, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 1.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CoilImage(
                data = item.image,
                contentDescription = "${item.name} image",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(Modifier.matchParentSize()) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                }
            )
            Text(
                text = item.name, modifier = Modifier
                    .weight(1f),
                style = MaterialTheme.typography.h2
            )
        }
    }
}