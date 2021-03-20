package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.androiddevchallenge.model.homeGardenItems
import com.example.androiddevchallenge.model.themes
import com.example.androiddevchallenge.ui.components.HomeGardenCard
import com.example.androiddevchallenge.ui.components.ThemeCard
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen() {
    Scaffold(bottomBar = { BottomBar() }) {
        ConstraintLayout {
            val (searchTextField, browseThemeText, themeList, designGardenText, designGardenList, filterButton) = createRefs()

            var searchInput by remember { mutableStateOf("") }
            OutlinedTextField(
                value = searchInput,
                leadingIcon = { Icon(Icons.Outlined.Search, "Search") },
                onValueChange = {
                    searchInput = it
                },
                placeholder = { Text(text = "Search") },
                textStyle = MaterialTheme.typography.body1,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(searchTextField) {
                        top.linkTo(parent.top, margin = 8.dp)
                    }
                    .padding(start = 16.dp, end = 16.dp)
            )
            Text(
                text = "Browse themes",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .paddingFromBaseline(top = 32.dp)
                    .constrainAs(browseThemeText) {
                        top.linkTo(searchTextField.bottom)
                    },
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Start
            )
            LazyRow(
                Modifier
                    .fillMaxWidth()
                    .height(136.dp)
                    .constrainAs(themeList) {
                        top.linkTo(browseThemeText.bottom)
                    },
                contentPadding = PaddingValues(16.dp)
            ) {
                itemsIndexed(themes) { index, item ->
                    ThemeCard(
                        item = item,
                        Modifier
                            .padding(start = if (index == 0) 0.dp else 8.dp)
                            .fillMaxHeight()
                            .aspectRatio(1.2f)
                    )
                }
            }
            Text(text = "Design your home garden",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .constrainAs(designGardenText) {
                        top.linkTo(themeList.bottom)
                    }
                    .paddingFromBaseline(top = 40.dp),
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Start)

            Icon(
                Icons.Filled.FilterList,
                "Sort",
                modifier = Modifier
                    .padding(end = 16.dp)
                    .height(24.dp)
                    .aspectRatio(1f)
                    .clickable { }
                    .constrainAs(filterButton) {
                        top.linkTo(designGardenText.top)
                        bottom.linkTo(designGardenText.bottom)
                        end.linkTo(parent.end)
                    })
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .constrainAs(designGardenList) {
                        top.linkTo(designGardenText.bottom)
                        bottom.linkTo(parent.bottom)
                        height = Dimension.preferredWrapContent
                    }
                    .fillMaxHeight(),
                contentPadding = PaddingValues(top = 16.dp, bottom = 64.dp)
            ) {
                items(homeGardenItems) { item ->
                    HomeGardenCard(item)
                }
            }
        }
    }
}

@Composable
private fun BottomBar() {
    BottomNavigation(
        contentColor = MaterialTheme.colors.onPrimary,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = { /*TODO*/ },
            label = { Text("Home") },
            icon = {
                Icon(
                    Icons.Filled.Home,
                    "Home"
                )
            })
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            label = { Text("Favorites") },
            icon = {
                Icon(
                    Icons.Outlined.Favorite,
                    "Favorites"
                )
            })
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            label = { Text("Profile") },
            icon = {
                Icon(
                    Icons.Filled.AccountCircle,
                    "Profile"
                )
            })
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            label = { Text("Cart") },
            icon = {
                Icon(
                    Icons.Filled.ShoppingCart,
                    "Cart"
                )
            })

    }
}

@Preview("[Dark Theme]Home screen", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewHomeScreen() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}

@Preview("[Light Theme]Home screen", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewHomeScreen() {
    MyTheme {
        HomeScreen()
    }
}