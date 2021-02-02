package com.example.kotlinapp_tetu.injection

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext

class ESIEAapp() : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin() {
            androidContext(this@ESIEAapp)
            modules(PresentationModule, DomainModule, DataModule)
        }
    }
}


