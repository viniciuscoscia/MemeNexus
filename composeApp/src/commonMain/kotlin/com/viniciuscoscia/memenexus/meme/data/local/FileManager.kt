package com.viniciuscoscia.memenexus.meme.data.local

expect interface FileManager {
    fun getMemeTemplates(): List<ByteArray>
}