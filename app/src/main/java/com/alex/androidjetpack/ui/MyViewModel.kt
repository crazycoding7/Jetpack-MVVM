package com.alex.androidjetpack.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.androidjetpack.data.model.UserEntity
import kotlinx.coroutines.launch

class MyViewModel :ViewModel(){
    private val users:MutableLiveData<List<UserEntity>> by lazy {
        MutableLiveData<List<UserEntity>>()
    }

    fun getUser():LiveData<List<UserEntity>>{
        return users
    }

    fun loadUsers(){
        viewModelScope.launch{
            users.value = ArrayList<UserEntity>().apply {
                add(UserEntity("张三",100))
            }

            Log.d("testme", "load data ${Thread.currentThread().name}")
        }
    }

}