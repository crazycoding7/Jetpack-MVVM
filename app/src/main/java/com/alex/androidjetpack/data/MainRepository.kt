package com.alex.androidjetpack.data

import android.util.Log
import com.alex.androidjetpack.data.network.MainService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository {

    suspend fun netMainData(): String = withContext(Dispatchers.IO) {
        val response = MainService.getMainData()
        Log.e(
            "MainActivity",
            "MainRepository ${Thread.currentThread().name} net success ${response.code} ${response.message}"
        )
        response.message
    }


    companion object {

        private lateinit var instance: MainRepository

        fun getInstance(): MainRepository {
            if (!::instance.isInitialized) {
                synchronized(MainRepository::class.java) {
                    if (!::instance.isInitialized) {
                        instance = MainRepository()
                    }
                }
            }
            return instance
        }

    }
}