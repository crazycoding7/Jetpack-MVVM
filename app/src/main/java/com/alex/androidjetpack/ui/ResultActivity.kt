package com.alex.androidjetpack.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.alex.androidjetpack.R
import com.alex.androidjetpack.data.model.UserModel
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val model:MyViewModel by viewModels()
        model.getUser().observe(this, Observer<List<UserModel>> {
            // update ui
            tv_second_test.text = it[0].name
        })

        tv_second_test.setOnClickListener {
            model.loadUsers()
        }

    }
}
