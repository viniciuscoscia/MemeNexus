package com.viniciuscoscia.memenexus.meme.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.viniciuscoscia.memenexus.core.presentation.DarkContent
import com.viniciuscoscia.memenexus.core.presentation.DarkSurface
import com.viniciuscoscia.memenexus.core.presentation.MemeNexusTheme
import com.viniciuscoscia.memenexus.core.presentation.components.DropdownMenuWithArrow
import com.viniciuscoscia.memenexus.core.presentation.components.RemoteSvgLoader
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun HomeScreenRoot() {
    MemeNexusTheme {
        HomeScreen()
    }
}

@Preview
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .background(DarkSurface)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeTopBar()
        HomeBody()
    }
}

@Composable
fun HomeFab(modifier: Modifier) {
    FloatingActionButton(
        modifier = modifier,
        onClick = {
            println("Create Meme")
        },
        content = {
            Text(
                fontWeight = FontWeight(350),
                fontSize = 30.sp,
                text = "+",
            )
        }
    )
}

@Preview
@Composable
private fun HomeTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .background(DarkContent)
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HomeTitle()
            val options = listOf("Favorites First", "Newest First")
            DropdownMenuWithArrow(
                options = options
            )
        }
    }
}

@Composable
private fun HomeBody() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.surfaceContainer
    ) {
        NoMemesCreatedYet()
    }
}

@Preview
@Composable
private fun NoMemesCreatedYet() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .navigationBarsPadding()
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            RemoteSvgLoader(
                modifier = Modifier
                    .fillMaxWidth(0.35f),
                svgPath = "https://meme-nexus.s3.us-east-2.amazonaws.com/AppSVGs/homeBackgroundEmptyList.svg"
            )

            Text(
                text = "Tap + button to create your first meme",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(16.dp)
            )
        }

        HomeFab(
            modifier = Modifier
                .padding(
                    all = 24.dp,
                )
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
private fun HomeTitle() {
    Text(
        text = "Your Memes",
        style = MaterialTheme.typography.headlineMedium,
        color = Color.White,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

