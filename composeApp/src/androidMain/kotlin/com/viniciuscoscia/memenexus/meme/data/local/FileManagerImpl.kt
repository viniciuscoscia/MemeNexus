package com.viniciuscoscia.memenexus.meme.data.local

import android.content.Context

class FileManagerImpl(
    private val applicationContext: Context
) : FileManager {
    override fun getMemeTemplates(): List<ByteArray> {
        val folder = applicationContext.assets.list("MemeTemplates")
        return folder?.map {
            applicationContext.assets.open("MemeTemplates/$it").readBytes()
        } ?: emptyList()
    }
}