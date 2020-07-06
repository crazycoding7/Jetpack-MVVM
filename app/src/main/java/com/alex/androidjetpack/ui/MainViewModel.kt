package com.alex.androidjetpack.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    val contentMessage = MutableLiveData("默认值")

    fun getMessage() {
    }
}