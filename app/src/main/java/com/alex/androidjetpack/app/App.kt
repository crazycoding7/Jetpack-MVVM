package com.alex.androidjetpack.app

import android.app.Application
import android.util.Log

lateinit var INSTANCE: Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        Thread.setDefaultUncaughtExceptionHandler { t, e ->
            Log.e(
                "AppApplication",
                t.toString() + " " + e.message
            )
        }
    }

}