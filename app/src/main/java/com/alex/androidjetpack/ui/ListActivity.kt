package com.alex.androidjetpack.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alex.androidjetpack.R

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }
}
