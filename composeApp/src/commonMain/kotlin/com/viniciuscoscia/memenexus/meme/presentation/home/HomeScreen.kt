package com.viniciuscoscia.memenexus.meme.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.viniciuscoscia.memenexus.core.presentation.DarkContent
import com.viniciuscoscia.memenexus.core.presentation.DarkSurface
import com.viniciuscoscia.memenexus.core.presentation.MemeNexusTheme
import com.viniciuscoscia.memenexus.core.presentation.components.DropdownMenuWithArrow
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.svg.SvgDecoder
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreenRoot() {
    MemeNexusTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkSurface)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeTopBar()
        HomeBody()
    }
}

@Composable
private fun HomeTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .background(DarkContent)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Title()
            val options = listOf("Favorites First", "Newest First")
            DropdownMenuWithArrow(
                options = options
            )
        }
    }
}

@Composable
fun ColumnScope.HomeBody() {
    Surface(
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.surfaceContainer
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RemoteSvgLoader3(svgPath = "https://meme-nexus.s3.us-east-2.amazonaws.com/AppSVGs/homeBackgroundEmptyList.svg")
        }
    }
}

@Composable
fun RemoteSvgLoader3(svgPath: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalPlatformContext.current)
            .data(svgPath)
            .decoderFactory(SvgDecoder.Factory())
            .build(),
        contentDescription = "Empty List Background",
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun Title() {
    Text(
        text = "Your Memes",
        style = MaterialTheme.typography.headlineMedium,
        color = Color.White,
        modifier = Modifier.padding(16.dp)
    )
}

