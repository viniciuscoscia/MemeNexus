package com.viniciuscoscia.memenexus.di

import com.viniciuscoscia.memenexus.meme.data.local.FileManager
import com.viniciuscoscia.memenexus.meme.data.local.FileManagerImpl
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<HttpClientEngine> { OkHttp.create() }
        singleOf(::FileManagerImpl) bind FileManager::class
//        single { DatabaseFactory(androidApplication()) }
    }