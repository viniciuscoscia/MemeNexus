package com.viniciuscoscia.memenexus.meme.data.remote

import com.plcoding.bookpedia.core.domain.DataError
import com.viniciuscoscia.memenexus.core.domain.Result
import io.ktor.client.HttpClient

class RemoteMemeDataSourceImpl(
    private val httpClient: HttpClient
) : RemoteMemeDataSource {

    override suspend fun fetchMemes(): Result<Any, DataError.Remote> {
        return Result.Success(data = Any())
    }
}