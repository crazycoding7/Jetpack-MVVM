package com.alex.androidjetpack.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alex.androidjetpack.R
import com.alex.androidjetpack.databinding.ActivityMainBinding
import com.alex.androidjetpack.util.InjectorUtil

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(InjectorUtil.getMainRepository())
    }

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        binding.lifecycleOwner = this
    }

    /**
     * click handler
     */
    inner class ClickHandler {
        fun btnClick() {
            viewModel.getMessage()
        }
    }
}

