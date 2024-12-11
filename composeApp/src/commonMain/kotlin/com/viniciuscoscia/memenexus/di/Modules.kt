package com.viniciuscoscia.memenexus.di

import com.viniciuscoscia.memenexus.core.data.HttpClientFactory
import com.viniciuscoscia.memenexus.meme.data.remote.RemoteMemeDataSource
import com.viniciuscoscia.memenexus.meme.data.remote.RemoteMemeDataSourceImpl
import com.viniciuscoscia.memenexus.meme.data.repository.MemeRepositoryImpl
import com.viniciuscoscia.memenexus.meme.domain.MemeRepository
import com.viniciuscoscia.memenexus.meme.presentation.home.HomeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::MemeRepositoryImpl) bind MemeRepository::class
    singleOf(::RemoteMemeDataSourceImpl) bind RemoteMemeDataSource::class

//    single {
//        get<DatabaseFactory>().create()
//            .setDriver(BundledSQLiteDriver())
//            .build()
//    }

    viewModelOf(::HomeViewModel)
}