package com.alex.jetpackmvvm.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class BaseViewModel :ViewModel(){

    fun launch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit) = run {
        viewModelScope.launch {
            try {
                block()
            } catch (e: Throwable) {
                error(e)
            }
        }
    }
}