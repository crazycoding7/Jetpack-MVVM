package com.alex.androidjetpack.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.alex.androidjetpack.R
import com.alex.androidjetpack.app.base.BaseActivity
import com.alex.androidjetpack.databinding.ActivityLoginBinding
import com.alex.androidjetpack.viewmodel.LoginViewModel
import com.alex.jetpackmvvm.base.BaseVmDBActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginViewModel,ActivityLoginBinding>() {

    override fun layoutId(): Int = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {
        mDataBinding.viewModel = mViewModel
        mDataBinding.clickProxy = ClickProxy()
    }

    override fun createObserver() {
        mViewModel.loginData.observe(this, Observer {
            closeLoading()
            if(!it.isSuccess()){
                showToast("登录失败 error = ${it.message}")
                return@Observer
            }

            showToast("登录成功 token = ${it.data.token}")
            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
        })
    }

    inner class ClickProxy{

        fun login(){
            when{
//                et_username.text.toString().isEmpty() -> showToast("请输入账号")
//                et_password.text.toString().isEmpty() -> showToast("请输入密码")
                else -> {
                    showLoading()
                    mViewModel.login(et_username.text.toString(),et_password.text.toString())
                }
            }

        }

    }
}
