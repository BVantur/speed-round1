package com.example.androiddevchallenge.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun ThemedImage(@DrawableRes lightImage: Int, @DrawableRes darkImage: Int, modifier: Modifier = Modifier, contentDescription: String = "", contentScale: ContentScale = ContentScale.FillBounds) {
    if (isSystemInDarkTheme()) {
        Image(modifier = modifier, painter = painterResource(darkImage), contentDescription = contentDescription, contentScale = contentScale )
    } else {
        Image(modifier = modifier, painter = painterResource(lightImage), contentDescription = contentDescription, contentScale = contentScale )
    }
}