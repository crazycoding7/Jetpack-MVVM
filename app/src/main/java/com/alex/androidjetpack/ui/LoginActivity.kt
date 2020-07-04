package com.alex.androidjetpack.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.alex.androidjetpack.R
import com.alex.androidjetpack.databinding.ActivityLoginBinding
import com.alex.androidjetpack.viewmodel.LoginViewModel
import com.alex.jetpackmvvm.base.BaseVmDBActivity
//BaseVmDBActivity<LoginViewModel, ActivityLoginBinding>()
class LoginActivity :AppCompatActivity(){

    //override fun layoutId(): Int = R.layout.activity_login


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_result)
    }
}