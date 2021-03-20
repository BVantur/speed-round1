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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.example.androiddevchallenge.ui.ROUTE_HOME
import com.example.androiddevchallenge.ui.ROUTE_LOGIN
import com.example.androiddevchallenge.ui.ROUTE_WELCOME
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LoginScreen(navController: NavController?) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        val (titleText, emailTextField, passwordTextField, termsText, loginButton) = createRefs()
        Text(
            text = "Log in with email",
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .constrainAs(titleText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.preferredWrapContent
                }
                .paddingFromBaseline(top = 184.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { /*TODO*/ },
            placeholder = { Text(text = "Email address") },
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier
                .constrainAs(emailTextField) {
                    top.linkTo(titleText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { /*TODO*/ },
            placeholder = { Text(text = "Password (8+ characters)") },
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier
                .constrainAs(passwordTextField) {
                    top.linkTo(emailTextField.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = "By clicking below, you agree to our Terms of Use and consent to our Privacy Policy.",
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .constrainAs(termsText) {
                    top.linkTo(passwordTextField.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        Button(
            onClick = {
                navController?.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_WELCOME) { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .constrainAs(loginButton) {
                    top.linkTo(termsText.bottom)
                    start.linkTo(parent.start)
                    height = Dimension.value(48.dp)
                    end.linkTo(parent.end)
                },
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
        ) {
            Text(
                "Log in",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onSecondary
            )
        }
    }
}

@Preview("[Dark Theme]Login screen", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewLoginScreen() {
    MyTheme(darkTheme = true) {
        LoginScreen(null)
    }
}

@Preview("[Light Theme]Login screen", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewLoginScreen() {
    MyTheme {
        LoginScreen(null)
    }
}
