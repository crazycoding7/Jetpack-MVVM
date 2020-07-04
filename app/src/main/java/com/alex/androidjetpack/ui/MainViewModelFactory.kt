package com.alex.androidjetpack.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alex.androidjetpack.app.INSTANCE
import com.alex.androidjetpack.data.MainRepository

class MainViewModelFactory(private val repository: MainRepository) :
    ViewModelProvider.AndroidViewModelFactory(
        INSTANCE
    ) {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}