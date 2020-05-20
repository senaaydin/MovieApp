package com.sena.movieapp.base

import android.app.Application
import com.sena.movieapp.base.di.AppComponent
import com.sena.movieapp.base.di.DaggerAppComponent


class MyAppClass: Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}