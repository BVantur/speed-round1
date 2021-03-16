package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ThemedText(text: String, lightColor: Color, darkColor: Color, modifier: Modifier = Modifier) {
    if (isSystemInDarkTheme()) {
        Text(text, modifier = modifier, color = darkColor)
    } else {
        Text(text, modifier = modifier, color = lightColor)
    }
}