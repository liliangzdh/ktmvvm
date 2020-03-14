package com.kaoyaya.kt

import android.app.Application
import com.kaoyaya.kt.di.appModule
import com.kaoyaya.mvvmbase.CommonApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application(){


    override fun onCreate() {
        super.onCreate()
        CommonApplication.init(this)

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }

}