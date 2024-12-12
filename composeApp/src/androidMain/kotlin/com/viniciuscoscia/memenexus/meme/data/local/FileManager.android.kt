package com.viniciuscoscia.memenexus.meme.data.local

actual interface FileManager {
    actual fun getMemeTemplates(): List<ByteArray>
}