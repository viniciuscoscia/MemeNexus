package com.viniciuscoscia.memenexus.meme.data.repository

import com.plcoding.bookpedia.core.domain.DataError
import com.viniciuscoscia.memenexus.core.domain.Result
import com.viniciuscoscia.memenexus.meme.data.local.FileManager
import com.viniciuscoscia.memenexus.meme.data.remote.RemoteMemeDataSource
import com.viniciuscoscia.memenexus.meme.domain.MemeRepository
import com.viniciuscoscia.memenexus.meme.domain.entity.Meme

class MemeRepositoryImpl(
    private val remoteMemeDataSource: RemoteMemeDataSource,
    private val fileManager: FileManager
) : MemeRepository {
    override fun getUserMemes(): Result<List<Meme>, DataError.Remote> {
        return Result.Success(emptyList())
//        return remoteMemeDataSource
//            .getMemes()
//            .map {
//
//            }
    }

    override fun getMemesTemplatePath(): List<ByteArray> {
        val memeTemplates = fileManager.getMemeTemplates()
        println(memeTemplates.size)
        memeTemplates.forEach {
            println(it)
        }
        return memeTemplates
    }

//    override suspend fun searchBooks(query: String): kotlin.Result<List<Book>, DataError.Remote> {
//        return remoteBookDataSource
//            .searchBooks(query)
//            .map { dto ->
//                dto.results.map { it.toBook() }
//            }
//    }

}