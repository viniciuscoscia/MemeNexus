package com.viniciuscoscia.memenexus.meme.presentation.home

import com.viniciuscoscia.memenexus.meme.domain.entity.MemeTemplate

sealed interface HomeAction {
    data class OnMemeTemplateSelected(val memeTemplate: MemeTemplate) : HomeAction
}