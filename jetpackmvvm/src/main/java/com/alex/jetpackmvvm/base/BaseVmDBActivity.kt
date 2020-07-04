package com.alex.jetpackmvvm.base

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseVmDBActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmActivity<VM>() {

    lateinit var mDataBinding: DB

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.e("testme", "BaseVmDBActivity $isUseDataBinding")
        initDataBinding()
    }

    fun initDataBinding(){
        mDataBinding = DataBindingUtil.setContentView(this,layoutId())
        mDataBinding.lifecycleOwner = this
    }

}