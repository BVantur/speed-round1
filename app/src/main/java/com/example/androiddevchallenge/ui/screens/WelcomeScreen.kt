/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.ROUTE_LOGIN
import com.example.androiddevchallenge.ui.components.ThemedImage
import com.example.androiddevchallenge.ui.components.ThemedText
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.typography
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun WelcomeScreen(navController: NavController?) {
    Surface(modifier = Modifier
        .fillMaxSize(), color = MaterialTheme.colors.primary) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (backgroundImage, illosImage, logoImage, introText, createAccountButton, loginButton) = createRefs()
        val topGuideline = createGuidelineFromTop(72.dp)
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
        Text(
            "Beautiful home garden solution",
            modifier = Modifier
                .constrainAs(introText) {
                    top.linkTo(logoImage.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .paddingFromBaseline(top = 32.dp, bottom = 40.dp),
            style = typography.subtitle1,
        )

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .constrainAs(createAccountButton) {
                    top.linkTo(introText.bottom)
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
//                color = MaterialTheme.colors.onSecondary
            )
        }

        TextButton(
            onClick = {
                navController?.navigate(ROUTE_LOGIN)
            },
            shape = MaterialTheme.shapes.medium,
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
            Text(
                "Log in",
                style = MaterialTheme.typography.button,
//                color = MaterialTheme.colors.onSecondary
            )
        }
    }

    }
}

@Preview("[Dark Theme]Welcome screen", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewWelcomeScreen() {
    MyTheme(darkTheme = true) {
        WelcomeScreen(null)
    }
}

@Preview("[Light Theme]Welcome screen", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewWelcomeScreen() {
    MyTheme {
        WelcomeScreen(null)
    }
}
