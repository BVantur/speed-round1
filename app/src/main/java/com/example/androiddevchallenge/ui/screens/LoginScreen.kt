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

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.example.androiddevchallenge.ui.ROUTE_HOME
import com.example.androiddevchallenge.ui.ROUTE_WELCOME
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.fontFamily

@Composable
fun LoginScreen(navController: NavController?) {
    Surface {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            val (titleText, emailTextField, passwordTextField, termsText, loginButton) = createRefs()
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            Text(
                text = "Log in with email",
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
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email address") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier
                    .constrainAs(emailTextField) {
                        top.linkTo(titleText.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password (8+ characters)") },
                textStyle = MaterialTheme.typography.body1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .constrainAs(passwordTextField) {
                        top.linkTo(emailTextField.bottom, margin = 8.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            AnnotatedClickableText(modifier = Modifier
                .constrainAs(termsText) {
                    top.linkTo(passwordTextField.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp))
            Button(
                onClick = {
                    navController?.navigate(ROUTE_HOME) {
                        popUpTo(ROUTE_WELCOME) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
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
                    style = MaterialTheme.typography.button
                )
            }
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

@Preview("Annotated text")
@Composable
fun AnnotatedC() {
    MyTheme {
        AnnotatedClickableText()
    }
}

@Composable
fun AnnotatedClickableText(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val annotatedTextFirstPart = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onSurface
            )
        ) {
            append("By clicking below, you agree to our ")
        }
        pushStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com"
        )
        withStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
                color = MaterialTheme.colors.onSurface
            )
        ) {
            append("Terms of Use")
        }

        withStyle(
            style = SpanStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                        color = MaterialTheme.colors.onSurface
            )
        ) {
            append(" and consent")
        }
        pop()
    }
    val annotatedTextSecondPart = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onSurface
            )
        ) {
            append("to our ")
        }

        pushStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com"
        )
        withStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
                color = MaterialTheme.colors.onSurface
            )
        ) {
            append("Privacy Policy")
        }
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onSurface
            )
        ) {
            append(".")
        }
        pop()
    }


    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

        ClickableText(
            text = annotatedTextFirstPart,
            style = MaterialTheme.typography.body2,
            softWrap = true,
            onClick = { offset ->
                annotatedTextFirstPart.getStringAnnotations(
                    tag = "URL", start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    Toast.makeText(context, "Terms of Use", Toast.LENGTH_LONG).show()
                }
            }
        )
        ClickableText(
            text = annotatedTextSecondPart,
            style = MaterialTheme.typography.body2,
            softWrap = true,
            onClick = { offset ->
                annotatedTextSecondPart.getStringAnnotations(
                    tag = "URL", start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    Toast.makeText(context, "Privacy Policy", Toast.LENGTH_LONG).show()
                }
            }
        )

    }
}
