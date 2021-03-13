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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

val fontFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.nunitosans_bold,
            style = FontStyle.Normal,
            weight = FontWeight.Bold
        ),
        Font(
            resId = R.font.nunitosans_light,
            style = FontStyle.Normal,
            weight = FontWeight.Light
        ),
        Font(
            resId = R.font.nunitosans_semibold,
            style = FontStyle.Normal,
            weight = FontWeight.SemiBold
        )
    )
)

// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontSize = 18.sp,
        letterSpacing = 0.em,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    ),
    h2 = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 0.15.em,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    ),
    subtitle1 = TextStyle(
        fontSize = 16.sp,
        letterSpacing = 0.em,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Light
    ),
    body1 = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 0.em,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Light,
    ),
    body2 = TextStyle(
        fontSize = 12.sp,
        letterSpacing = 0.em,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Light,
    ),
    button = TextStyle(
        fontSize = 12.sp,
        letterSpacing = 1.em,
        fontFamily = fontFamily,
        fontWeight = FontWeight.SemiBold,
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        letterSpacing = 0.em,
        fontFamily = fontFamily,
        fontWeight = FontWeight.SemiBold,
    )
)


