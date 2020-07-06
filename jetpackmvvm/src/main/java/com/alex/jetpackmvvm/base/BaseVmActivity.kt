package com.alex.jetpackmvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alex.jetpackmvvm.ext.getVmClazz

abstract class BaseVmActivity<VM : BaseViewModel> : AppCompatActivity() {

    var isUseDataBinding: Boolean = false

    lateinit var mViewModel: VM

    abstract fun layoutId(): Int

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun createObserver()

//    abstract fun showLoading(message: String = "请求网络中...")
//
//    abstract fun dismissLoading()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isUseDataBinding) {
            initDataBind()
        } else {
            setContentView(layoutId())
        }
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        mViewModel = createViewModel()
        initView(savedInstanceState)
        createObserver()
    }

    private fun createViewModel(): VM  = ViewModelProvider(this).get(getVmClazz(this))

    open fun initDataBind() {}
}