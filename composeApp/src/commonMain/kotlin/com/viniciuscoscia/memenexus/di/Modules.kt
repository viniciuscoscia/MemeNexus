package com.viniciuscoscia.memenexus.di

import com.viniciuscoscia.memenexus.core.data.HttpClientFactory
import com.viniciuscoscia.memenexus.meme.presentation.home.HomeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }

//    single {
//        get<DatabaseFactory>().create()
//            .setDriver(BundledSQLiteDriver())
//            .build()
//    }

    viewModelOf(::HomeViewModel)
}