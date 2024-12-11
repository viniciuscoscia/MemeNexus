package com.viniciuscoscia.memenexus.meme.data.remote

import com.plcoding.bookpedia.core.domain.DataError
import com.viniciuscoscia.memenexus.core.domain.Result

interface RemoteMemeDataSource {
    suspend fun fetchMemes(): Result<Any, DataError.Remote>
}