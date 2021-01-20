package com.alex.androidjetpack.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alex.androidjetpack.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivityCoroutine"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_hello.setOnClickListener {
            //netTest()
             testRx()
        }
    }


    @SuppressLint("UseValueOf")
    private fun testRx() {
        // 事件发生 被观察者
        var observable: Observable<Integer> = Observable.create {
            //处理网络请求或其他业务无关逻辑
            it.onNext(Integer(1))
            Log.e(TAG, "observable onNext 1 " + Thread.currentThread().name)
            it.onNext(Integer(2))
            it.onNext(Integer(3))
            it.onComplete()
            Log.e(TAG, "observable onComplete")
            it.onNext(Integer(4))
            Log.e(TAG, "observable onComplete 后的 onNext")
        }

        observable.doOnNext {
            // 处理data,其他线程
            Log.e(TAG, "observable doOnNext() $it")

        }

        // 事件处理 UI观察者
        var observer:Observer<Integer> = object :Observer<Integer>{
            override fun onComplete() {
               Log.e(TAG, "observer onComplete()")
            }

            override fun onSubscribe(d: Disposable?) {
                Log.e(TAG, "observer onSubscribe()")
            }

            override fun onNext(t: Integer?) {
                Log.e(TAG, "observer onNext() = $t " + Thread.currentThread().name)
            }

            override fun onError(e: Throwable?) {
                Log.e(TAG, "observer onError()")
            }

        }

        observable.subscribeOn(Schedulers.newThread())  // 指定数据处理线程
            .observeOn(AndroidSchedulers.mainThread())  // 指定业务UI处理线程
            .subscribe(observer)
    }

    private fun netTest() {
        Log.e(TAG, "netTest() Main start...")

        CoroutineScope(Dispatchers.Main).launch {
            val result = async(Dispatchers.IO) { //或者withContext(Dispatchers.IO) {
                //使用okhttp使用同步请求，完事将response返回
                val request = Request.Builder().url("http://www.baidu.com").build()
                val response = OkHttpClient().newCall(request).execute()
                Log.e(TAG, "CoroutineScope  IO : ${Thread.currentThread().name}")

                response
            }
            Log.e(TAG, "CoroutineScope Main start : ${Thread.currentThread().name}")

            //等待异步执行的结果
            val response = result.await()
            //返回的结果，直接显示在sample_text这个textview上，也就是更新UI
            btn_jump.text = response.body()?.string()
            Log.e(TAG, "CoroutineScope Main end: ${Thread.currentThread().name}")
        }


        Log.e(TAG, "netTest() Main end...")
    }

}

