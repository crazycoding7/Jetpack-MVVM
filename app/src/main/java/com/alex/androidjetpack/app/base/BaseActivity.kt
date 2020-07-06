package com.alex.androidjetpack.app.base


import android.app.Dialog
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import com.alex.androidjetpack.R
import com.alex.jetpackmvvm.base.BaseViewModel
import com.alex.jetpackmvvm.base.BaseVmDBActivity

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmDBActivity<VM, DB>() {
    private var mDialog: Dialog? = null

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun showLoading() {
        if (mDialog != null) {
            mDialog?.show()
            return
        }
        mDialog = Dialog(this, R.style.OverallTranslucentBackground)
        mDialog?.run {
            setContentView(R.layout.dialog_loading)
            setCanceledOnTouchOutside(false)
            setCancelable(false)
            if (!this@BaseActivity.isFinishing) show()
        }
    }

    fun closeLoading() {
        mDialog?.run {
            if (isShowing) dismiss()
        }
    }


    override fun onDestroy() {
        closeLoading()
        super.onDestroy()
    }
}