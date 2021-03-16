package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.ThemedImage
import com.example.androiddevchallenge.ui.components.ThemedText
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.typography
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun WelcomeScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        val (backgroundImage, illosImage, logoImage, introText, createAccountButton, loginButton) = createRefs()
        val topGuideline = createGuidelineFromTop(72.dp)
        val startGuideline = createGuidelineFromStart(88.dp)
        ThemedImage(
            lightImage = R.drawable.ic_light_welcome_bg,
            darkImage = R.drawable.ic_dark_welcome_bg,
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(backgroundImage) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        ThemedImage(
            lightImage = R.drawable.ic_light_welcome_illos,
            darkImage = R.drawable.ic_dark_welcome_illos,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .offset(x = 88.dp)
                .constrainAs(illosImage) {
                    top.linkTo(topGuideline)
                    start.linkTo(parent.start)
                    height = Dimension.fillToConstraints
                    end.linkTo(parent.end)
                }
        )
        ThemedImage(
            lightImage = R.drawable.ic_light_logo,
            darkImage = R.drawable.ic_dark_logo,
            modifier = Modifier.constrainAs(logoImage) {
                top.linkTo(illosImage.bottom, margin = 48.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.preferredWrapContent
            }
        )
        Text("Beautiful home garden solution", modifier = Modifier.constrainAs(introText) {
            top.linkTo(logoImage.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }, style = typography.subtitle1, color = MaterialTheme.colors.onPrimary)

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .constrainAs(createAccountButton) {
                    top.linkTo(introText.bottom, margin = 48.dp)
                    start.linkTo(parent.start)
                    height = Dimension.value(48.dp)
                    end.linkTo(parent.end)
                },
            shape = MaterialTheme.shapes.medium,
            colors = buttonColors(backgroundColor = MaterialTheme.colors.secondary)
        ) {
            Text(
                "Create account",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onSecondary
            )
        }

        TextButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .constrainAs(loginButton) {
                    top.linkTo(createAccountButton.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    height = Dimension.value(48.dp)
                    end.linkTo(parent.end)
                },
            colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colors.onPrimary)
        ) {
            ThemedText("Log in", darkColor = white, lightColor = pink900)
        }
    }
}


@Preview("[Dark Theme]Welcome screen", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewWelcomeScreen() {
    MyTheme(darkTheme = true) {
        WelcomeScreen()
    }
}

@Preview("[Light Theme]Welcome screen", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewWelcomeScreen() {
    MyTheme {
        WelcomeScreen()
    }
}