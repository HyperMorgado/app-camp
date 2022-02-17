package com.example.camp.activity

import android.app.Application
import com.example.camp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                presentationModule,
                dataModule,
                dataRemoteModule,
                dataLocalModule,
                domainModule
            ).androidContext(applicationContext)
        }
    }
}