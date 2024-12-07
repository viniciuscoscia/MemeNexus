package com.viniciuscoscia.memenexus.meme.domain.entity

data class Meme(
    val id: String,
    val title: String?,
    val imageUrl: String,
    val createdDate: Long
)