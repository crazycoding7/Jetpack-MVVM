package com.alex.androidjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import com.alex.androidjetpack.data.model.LoginDataModel
import com.alex.androidjetpack.data.network.LoginService
import com.alex.jetpackmvvm.base.BaseViewModel

class LoginViewModel : BaseViewModel() {
    var loginData = MutableLiveData<LoginDataModel>()

    fun login(userName: String, pwd: String) {
        launch({
            loginData.value = LoginService.login(userName, pwd)
        }, {
            // error handler
        })
    }


}