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
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.transform.RoundedCornersTransformation
import com.example.androiddevchallenge.model.HomeGardenItem
import com.example.androiddevchallenge.model.homeGardenItems
import com.example.androiddevchallenge.ui.screens.HomeScreen
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun HomeGardenCard(item: HomeGardenItem) {
    Column(
        Modifier
            .fillMaxWidth()
            .height(64.dp)) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(63.dp)
                .background(MaterialTheme.colors.background)
                .padding(start = 16.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CoilImage(
                data = item.image,
                contentDescription = "${item.name} image",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.8f)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(Modifier.matchParentSize()) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                }
            )
            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(start = 16.dp)
                    .weight(3f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = item.name, style = MaterialTheme.typography.h2)
                Text(text = item.description, style = MaterialTheme.typography.body1)
            }

            var checked by remember { mutableStateOf(item.isChecked) }
            Checkbox(
                checked = checked,
                onCheckedChange = {

                    item.isChecked = !checked
                    checked = item.isChecked
                },
                Modifier.weight(1f),
                colors = CheckboxDefaults.colors(checkmarkColor = MaterialTheme.colors.background)
            )
        }
        Divider(modifier = Modifier.padding(start = 108.dp, end = 24.dp))
    }
}

@Preview
@Composable
fun PreviewHomeGardenCard() {
    MyTheme {
        HomeGardenCard(homeGardenItems.first())
    }
}
