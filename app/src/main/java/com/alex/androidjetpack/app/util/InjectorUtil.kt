package com.alex.androidjetpack.app.util

import com.alex.androidjetpack.data.MainRepository

object InjectorUtil {

    fun getMainRepository() = MainRepository.getInstance()

}