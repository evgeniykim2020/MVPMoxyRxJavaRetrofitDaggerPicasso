package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.base

import android.app.Application
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.di.DI

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        DI.init(applicationContext)
    }
}