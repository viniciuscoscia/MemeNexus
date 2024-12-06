package com.viniciuscoscia.memenexus.meme.presentation.home

import androidx.lifecycle.ViewModel
import com.viniciuscoscia.memenexus.meme.domain.MemeRepository

class HomeViewModel(
    private val memeRepository: MemeRepository
) : ViewModel() {
}