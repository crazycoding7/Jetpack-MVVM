package com.alex.jetpackmvvm.base

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseVmDBActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmActivity<VM>() {

    lateinit var mDataBinding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        isUseDataBinding = true
        super.onCreate(savedInstanceState)
    }

    override fun initDataBind() {
        mDataBinding = DataBindingUtil.setContentView(this, layoutId())
        mDataBinding.lifecycleOwner = this
    }
}