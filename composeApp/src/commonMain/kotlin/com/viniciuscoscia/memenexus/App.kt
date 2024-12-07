package com.viniciuscoscia.memenexus

import androidx.compose.runtime.Composable
import com.viniciuscoscia.memenexus.meme.presentation.home.HomeScreenRoot
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    HomeScreenRoot {
        println("Meme clicked: $it")
    }
}