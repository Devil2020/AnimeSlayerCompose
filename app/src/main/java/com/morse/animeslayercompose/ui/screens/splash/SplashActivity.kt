package com.morse.animeslayercompose.ui.screens.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.morse.animeslayercompose.ui.theme.AnimeSlayerComposeTheme

data class Artist(val name: String, val time: String, val category: Int = 0)

class SplashActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeSlayerComposeTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(scaffoldState = scaffoldState,
                    topBar = {
                        tryTopBar()
                    },
                    floatingActionButtonPosition = FabPosition.End,
                    isFloatingActionButtonDocked = true,
                    floatingActionButton = { tryExtendedFab() }
                ) {
                    draw ()
                }
            }
        }
    }
}



























/**/
// For Text Lesson

/**/
// For Animation Lesson About AnimationVisibility.
/*

@ExperimentalAnimationApi
@Preview(
    name = "Visibility Animation #1",
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)
@Composable
fun animationRoot1() {

    var visibilityState by remember {
        mutableStateOf(true)
    }
    val density = LocalDensity.current

    Column(modifier = Modifier.fillMaxSize()  , verticalArrangement = Arrangement.Center ) {

        AnimatedVisibility(
            modifier = Modifier.weight(1F),
            visible = visibilityState,
            enter = slideInVertically(
                // Slide in from 40 dp from the top.
                initialOffsetY = { with(density) { -40.dp.roundToPx() } } //
            ) + expandVertically(
                // Expand from the top.
                expandFrom = Alignment.Top
            ) + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {

            Text(
                " Animate Me For Managing Visibility State 🚀 ",
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }


        Button(
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth(),
            onClick = { visibilityState = visibilityState.not() }
        ) {
            Text(text = "Toggle ")
        }

    }

}

@ExperimentalTransitionApi
@ExperimentalAnimationApi
@Preview(
    name = "Visibility Animation #2",
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)
@Composable
fun animateRoot2 (){
    val state = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }
    Column {
        AnimatedVisibility(visibleState = state) {
            Text(text = "Hello, world!")
        }

        // Use the MutableTransitionState to know the current animation state
        // of the AnimatedVisibility.
        Text(
            text = when {
                state.isIdle && state.currentState -> "Visible"
                !state.isIdle && state.currentState -> "Disappearing"
                state.isIdle && !state.currentState -> "Invisible"
                else -> "Appearing"
            }
        )
    }
}
*/



// اقدر اتحكم فى الأتيمز بتاعتي عمتا جوا الأتيمز انيميتد فيزيبلتي عن طريق الأتيمز موديفير عمتا
/*@ExperimentalTransitionApi
@ExperimentalAnimationApi
@Preview(
    name = "Visibility Animation #3",
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)
@Composable
fun animateEnterAndExitAnimation() {
    var visible by remember {
        mutableStateOf(true)
    }
    AnimatedVisibility(
        visible = visible,
        // Fade in/out the background and the foreground.
        enter = fadeIn(),
        exit = fadeOut()
    ) {

        val background by transition.animateColor { state ->
            if (state == EnterExitState.Visible) Color.Blue else Color.Gray
        }

        Box(
            Modifier
                .fillMaxSize()
                .background(background)) {
            Box(
                Modifier
                    .align(Alignment.Center)
                    .animateEnterExit(
                        // Slide in/out the inner box.
                        enter = slideInVertically() + EnterTransition.None,
                        exit = slideOutVertically() + ExitTransition.None
                    )
                    .sizeIn(minWidth = 256.dp, minHeight = 64.dp)
                    .background(Color.Red)
                    .clickable {
                        visible = visible.not()
                    }
            ) {
                // Content of the notification…
            }
        }
    }
}*/

/**/
// For Animation Lesson About AnimationContent .

/*@ExperimentalTransitionApi
@ExperimentalAnimationApi
@Preview(
    name = "Content Animation #1",
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)
@Composable
fun contentAnimation1() {
    Row {
        var count by remember { mutableStateOf(0) }
        Button(onClick = { count++ }) {
            Text("Add1")
        }
        AnimatedContent(targetState = count) { targetCount ->
            Text(text = "Count1 : $targetCount")
        }

        var countt by remember { mutableStateOf(0) }
        Button(onClick = { countt++ }) {
            Text("Add2")
        }
        AnimatedContent(targetState = countt ,
            transitionSpec = {
                // Compare the incoming number with the previous number.
                if (targetState > initialState) {
                    // If the target number is larger, it slides up and fades in
                    // while the initial (smaller) number slides up and fades out.
                    slideInVertically({ height -> height }) + fadeIn() with
                            slideOutVertically({ height -> -height }) + fadeOut()
                } else {
                    // If the target number is smaller, it slides down and fades in
                    // while the initial number slides down and fades out.
                    slideInVertically({ height -> -height }) + fadeIn() with
                            slideOutVertically({ height -> height }) + fadeOut()
                }.using(
                    // Disable clipping since the faded slide-in/out should
                    // be displayed out of bounds.
                    SizeTransform(clip = false)
                )
            }) { targetCount ->
            Text(text = "Count2 : $targetCount")
        }

    }
}

@ExperimentalMaterialApi
@ExperimentalTransitionApi
@ExperimentalAnimationApi
@Preview(
    name = "Content Animation #2",
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)
@Composable
fun contentAnimation2 (){
    var expanded by remember { mutableStateOf(false) }
    Surface(
        color = MaterialTheme.colors.primary,
        onClick = { expanded = !expanded }
    ) {
        AnimatedContent(
            targetState = expanded,
            transitionSpec = {
                fadeIn(animationSpec = tween(150, 150)) with
                        fadeOut(animationSpec = tween(150)) using
                        SizeTransform { initialSize, targetSize ->
                            if (targetState) {
                                keyframes {
                                    // Expand horizontally first.
                                    IntSize(targetSize.width, initialSize.height) at 150
                                    durationMillis = 300
                                }
                            } else {
                                keyframes {
                                    // Shrink vertically first.
                                    IntSize(initialSize.width, targetSize.height) at 150
                                    durationMillis = 300
                                }
                            }
                        }
            }
        ) { targetExpanded ->
            if (targetExpanded) {
              //  Expanded()
            } else {
             //   ContentIcon()
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalTransitionApi
@ExperimentalAnimationApi
@Preview(
    name = "Content Animation #4",
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)
@Composable
fun contentAnimation3 (){
    var number by remember { mutableStateOf(1) }
    Button(
        onClick = { number *= 10 },
        modifier = Modifier.animateContentSize()
    ) {
        Text(text = "$number times")
    }
}

@ExperimentalMaterialApi
@ExperimentalTransitionApi
@ExperimentalAnimationApi
@Preview(
    name = "Content Animation #3",
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)
@Composable
fun contentAnimation4 (){
    var currentPage by remember { mutableStateOf("A") }
    Crossfade(targetState = currentPage) { screen ->
        when (screen) {
            "A" -> Text("Page A")
            "B" -> Text("Page B")
        }
    }
}*/

/*
// For List Lesson

@Composable
fun ArtistCard(artist: Artist) {
    Column(modifier = Modifier
        .clickable {}
        .padding(10.dp)
        .fillMaxWidth()) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.sisley),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.Center) {

                Text(artist.name)
                Text(artist.time)

            }
        }
        Image(
            painter = painterResource(id = R.drawable.sisly_work),
            contentDescription = "work",
            modifier = Modifier
                .padding(vertical = 10.dp)
                .clip(RoundedCornerShape(5.dp))
        )

    }
}

@Preview(name = "Making a List with Column ", showSystemUi = true, device = Devices.PIXEL_4_XL)
@Composable
fun scrollableColumn() {
    val listOfArtists = arrayListOf(
        Artist("#1 - Mohammed Morse", "20 Minutes Ago"),
        Artist("#2 - Mohammed Morse", "22 Minutes Ago"),
        Artist("#3 - Mohammed Morse", "24 Minutes Ago"),
        Artist("#4 - Mohammed Morse", "26 Minutes Ago"),
        Artist("#5 - Mohammed Morse", "28 Minutes Ago"),
        Artist("#6 - Mohammed Morse", "30 Minutes Ago"),
    )

    val verticalScrollState = rememberScrollState(0)

    Column(modifier = Modifier.verticalScroll(verticalScrollState)) {
        for (artist in listOfArtists) {
            ArtistCard(artist = artist)
        }
    }

}


@ExperimentalFoundationApi
@Preview(
    name = "Making a List with a Lazy One Column ",
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)
@Composable
fun lazyColu() {
    val listOfArtists = arrayListOf(
        Artist("#1 - Mohammed Morse", "20 Minutes Ago"),
        Artist("#2 - Mohammed Morse", "22 Minutes Ago"),
        Artist("#3 - Mohammed Morse", "24 Minutes Ago"),
        Artist("#4 - Mohammed Morse", "26 Minutes Ago"),
        Artist("#5 - Mohammed Morse", "28 Minutes Ago"),
        Artist("#6 - Mohammed Morse", "30 Minutes Ago"),
    )

    LazyColumn {
        stickyHeader {
            customStickyHeader(textValue = listOfArtists.get(0).name)
        }
        items(listOfArtists, key = { it.name }) { artist ->
            ArtistCard(artist = artist)
        }

    }

}

@ExperimentalFoundationApi
@Preview(
    name = "Making a List with a Lazy Column and Multiple Header ",
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)
@Composable
fun lazyWithOneStickyHeaderColu() {
    val listOfArtists = arrayListOf(
        Artist("#1 - Mohammed Morse", "20 Minutes Ago" , 2),
        Artist("#2 - Mohammed Morse", "22 Minutes Ago" , 3),
        Artist("#3 - Mohammed Morse", "24 Minutes Ago" , 4),
        Artist("#4 - Mohammed Morse", "26 Minutes Ago" , 5),
        Artist("#5 - Mohammed Morse", "28 Minutes Ago" , 6),
        Artist("#6 - Mohammed Morse", "30 Minutes Ago" , 7),
    )
    val groupedArtist  = listOfArtists.groupBy {
       if ( it.category % 2 == 0 ) "Even" else "Odd"
    }

    LazyColumn {

        groupedArtist.forEach {
            stickyHeader {
                customStickyHeader(textValue = it.key)
            }

            items(it.value) {
                artist ->
                ArtistCard(artist = artist)
            }
        }

    }

}

@Composable
fun customStickyHeader( textValue : String){
    Text(text = textValue , color = MaterialTheme.colors.error , fontFamily = FontFamily.SansSerif)
}*/
