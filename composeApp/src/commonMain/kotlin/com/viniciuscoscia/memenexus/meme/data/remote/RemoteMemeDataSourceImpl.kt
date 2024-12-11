package com.viniciuscoscia.memenexus.meme.data.remote

import com.plcoding.bookpedia.core.domain.DataError
import com.viniciuscoscia.memenexus.core.domain.Result
import io.ktor.client.HttpClient

class RemoteMemeDataSourceImpl(
    private val httpClient: HttpClient
) : RemoteMemeDataSource {
    //    safeCall<SearchResponseDto> {
//        httpClient.get(
//            urlString = "$BASE_URL/search.json"
//        ) {
//            parameter("q", query)
//            parameter("limit", resultLimit)
//            parameter("language", "eng")
//            parameter("fields", "key,title,author_name,author_key,cover_edition_key,cover_i,ratings_average,ratings_count,first_publish_year,language,number_of_pages_median,edition_count")
//        }
//    }
    override suspend fun fetchMemes(): Result<Any, DataError.Remote> {
        return Result.Success(data = Any())
    }
}