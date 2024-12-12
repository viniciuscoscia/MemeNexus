package com.viniciuscoscia.memenexus.meme.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viniciuscoscia.memenexus.meme.domain.MemeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val memeRepository: MemeRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state
        .onStart {
//            if(cachedBooks.isEmpty()) {
//                observeSearchQuery()
//            }
//            observeFavoriteBooks()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    init {
        memeRepository.getMemesTemplatePath()
    }

    fun onAction(action: HomeAction) {

    }
}