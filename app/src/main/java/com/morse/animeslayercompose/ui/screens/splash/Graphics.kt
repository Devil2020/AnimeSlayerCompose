package com.morse.animeslayercompose.ui.screens.splash

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// me have Something Drawable floatingActionButtonPosition .
/*
    1 - drawArch
    2 - drawCircule
    3 - drawImage
    4 - drawIntoCanvas
    5 - drawLine
    6 - drawOutLine
    7 - drawOval
    8 - drawPath
    9 -  drawPoints
    10 - drawRect
    11 - drawRoundRect
*/
@Preview(name = "Draw a Circule", showSystemUi = true, device = Devices.PIXEL_4_XL)
@ExperimentalFoundationApi
@Composable
fun draw() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Gray)) {
        // draweACircle()
        draweARectangle()
    }
}


@ExperimentalFoundationApi
@Composable
fun draweACircle() {

    Canvas(modifier = Modifier.requiredSize(60.dp), contentDescription = "CirculeOne") {
        drawCircle(color = Color.Red, size.minDimension)
    }

}


@ExperimentalFoundationApi
@Composable
fun draweARectangle() {
    Canvas(modifier = Modifier) {
        val canvasQuadrantSize = size / 2F
        inset(50F, 30F) {
            drawRect (
                color = Color.Green,
                size = canvasQuadrantSize
            )
        }
    }
}