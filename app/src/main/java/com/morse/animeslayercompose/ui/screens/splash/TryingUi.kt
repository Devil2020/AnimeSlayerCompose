package com.morse.animeslayercompose.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun ScaffoldState.showSnackbar (coroutineScope: CoroutineScope){
    coroutineScope.launch {
        snackbarHostState.showSnackbar("New Data InComing")
    }
}

@Composable
fun tryTopBar() {
    TopAppBar {
        Text(text = "Welcome in Study 💘")
    }
}

@Composable
fun tryButton() {
    Button(
        onClick = { /* ... */ },
        // Uses ButtonDefaults.ContentPadding by default
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
    ) {
        // Inner content including an icon and a text label
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like")
    }
}

@Composable
fun tryExtendedFab() {
    ExtendedFloatingActionButton(
        onClick = { /* ... */ },
        icon = {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite",
                tint = Color.White
            )
        },
        text = { Text("Like", color = Color.White) }
    )
}

@Composable
fun tryBoxWithConstains() {
    BoxWithConstraints {

        Column {
            Text("My minWidth is ${this@BoxWithConstraints.minWidth} while my maxWidth is ${this@BoxWithConstraints.maxWidth}")
            Text("My minHeight is ${this@BoxWithConstraints.minHeight} while my maxHeight is ${this@BoxWithConstraints.maxHeight}")
        }
    }
}

@Composable
fun tryBox() {

    Box {
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Gray)
        )
       // ArtistCard(Artist("#1" , "00 duration time "))

    }

}