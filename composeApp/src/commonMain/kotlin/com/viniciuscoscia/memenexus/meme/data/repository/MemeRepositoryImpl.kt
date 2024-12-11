package com.viniciuscoscia.memenexus.meme.data.repository

import com.plcoding.bookpedia.core.domain.DataError
import com.viniciuscoscia.memenexus.core.domain.Result
import com.viniciuscoscia.memenexus.meme.data.remote.RemoteMemeDataSource
import com.viniciuscoscia.memenexus.meme.domain.MemeRepository
import com.viniciuscoscia.memenexus.meme.domain.entity.Meme

class MemeRepositoryImpl(
    private val remoteMemeDataSource: RemoteMemeDataSource
) : MemeRepository {
    override fun getUserMemes(): Result<List<Meme>, DataError.Remote> {
        return Result.Success(emptyList())
//        return remoteMemeDataSource
//            .getMemes()
//            .map {
//
//            }
    }

//    override suspend fun searchBooks(query: String): kotlin.Result<List<Book>, DataError.Remote> {
//        return remoteBookDataSource
//            .searchBooks(query)
//            .map { dto ->
//                dto.results.map { it.toBook() }
//            }
//    }

}