package com.viniciuscoscia.memenexus.meme.presentation.home

import com.viniciuscoscia.memenexus.meme.domain.entity.Meme

data class HomeState(
    val memes: List<Meme> = emptyList(),
)
