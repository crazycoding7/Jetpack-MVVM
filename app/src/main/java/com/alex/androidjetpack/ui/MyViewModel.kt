package com.alex.androidjetpack.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.androidjetpack.data.model.UserModel
import kotlinx.coroutines.launch

class MyViewModel :ViewModel(){
    private val users:MutableLiveData<List<UserModel>> by lazy {
        MutableLiveData<List<UserModel>>()
    }

    fun getUser():LiveData<List<UserModel>>{
        return users
    }

    fun loadUsers(){
        viewModelScope.launch{
            users.value = ArrayList<UserModel>().apply {
                add(UserModel("张三",100))
            }

            Log.d("testme", "load data ${Thread.currentThread().name}")
        }
    }

}