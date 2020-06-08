package com.alex.androidjetpack.util

import com.alex.androidjetpack.data.MainRepository

object InjectorUtil {

    fun getMainRepository() = MainRepository.getInstance()

}