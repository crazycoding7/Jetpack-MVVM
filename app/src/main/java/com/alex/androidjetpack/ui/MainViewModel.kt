package com.alex.androidjetpack.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.androidjetpack.data.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    val contentMessage = MutableLiveData("默认值")

    fun getMessage() {

        viewModelScope.launch {
            contentMessage.value = repository.netMainData()
        }
//        launch({
//        }, {
//            Log.e("testme", "网络异常")
//        })
    }

    private fun launch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit) =
        viewModelScope.launch {
            try {
                block()
            } catch (e: Throwable) {
                error(e)
            }
        }
}