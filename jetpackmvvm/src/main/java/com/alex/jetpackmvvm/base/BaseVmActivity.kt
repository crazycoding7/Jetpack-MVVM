package com.alex.jetpackmvvm.base

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseVmActivity<VM: BaseViewModel> : AppCompatActivity(){

    var isUseDataBinding:Boolean = false

    abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        Log.e("testme", "BaseVmDBActivity $isUseDataBinding")

    }
}