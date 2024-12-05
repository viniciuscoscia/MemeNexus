package com.viniciuscoscia.memenexus

import android.app.Application
import com.plcoding.bookpedia.di.initKoin
import org.koin.android.ext.koin.androidContext

class MemeNexusApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MemeNexusApplication)
        }
    }
}