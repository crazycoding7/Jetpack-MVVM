package com.alex.androidjetpack.app

import android.app.Application

lateinit var INSTANCE: Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

}