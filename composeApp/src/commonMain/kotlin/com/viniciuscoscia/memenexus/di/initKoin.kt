package com.plcoding.bookpedia.di

import com.viniciuscoscia.memenexus.di.platformModule
import com.viniciuscoscia.memenexus.di.sharedModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(sharedModule, platformModule)
    }
}