package com.alex.androidjetpack.data.network

import com.alex.androidjetpack.data.network.api.LoginApi
import com.alex.androidjetpack.data.network.api.MainApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 支持不同BaseUrl实例；
 * 支持不同模块Service实例;
 */
class Requester {
    companion object {
        private val retrofitMap = mutableMapOf<String, Retrofit>()

        private const val BASE_URL = "http://rest.apizza.net/mock/ba52c77a7eedae1792f1140308bbe400/"

        fun <T> getServiceByMain(service: Class<T>, baseUrl: String = BASE_URL): T {
            if (!retrofitMap.containsKey(baseUrl)) {
                val client = OkHttpClient.Builder().build()
                val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                    //格式转换
                    .addConverterFactory(GsonConverterFactory.create())
                    //正常的retrofit返回的是call，此方法用于将call转化成Rxjava的Observable或其他类型
                    //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build()
                retrofitMap[baseUrl] = retrofit
            }

            return retrofitMap[baseUrl]!!.create(service)
        }

        // other base url...
    }

}

// 主Service
object MainService :
    MainApi by Requester.getServiceByMain(MainApi::class.java)

// 登录Service
object LoginService :
    LoginApi by Requester.getServiceByMain(LoginApi::class.java)