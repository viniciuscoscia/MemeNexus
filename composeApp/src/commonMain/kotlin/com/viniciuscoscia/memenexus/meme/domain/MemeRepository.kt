package com.viniciuscoscia.memenexus.meme.domain

import com.plcoding.bookpedia.core.domain.DataError
import com.viniciuscoscia.memenexus.core.domain.Result
import com.viniciuscoscia.memenexus.meme.domain.entity.Meme

interface MemeRepository {
    fun getUserMemes(): Result<List<Meme>, DataError.Remote>
    fun getMemesTemplatePath(): List<ByteArray>
}