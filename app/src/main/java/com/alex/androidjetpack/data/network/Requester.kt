package com.alex.androidjetpack.data.network

import com.alex.androidjetpack.app.util.LogUtil
import com.alex.androidjetpack.data.network.api.LoginApi
import com.alex.androidjetpack.data.network.api.MainApi
import okhttp3.*
import okio.Buffer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

/**
 * 支持不同BaseUrl实例；
 * 支持不同模块Service实例;
 */
class Requester {
    companion object {
        const val TAG = "Requester"
        private val retrofitMap = mutableMapOf<String, Retrofit>()
        private const val BASE_URL = "http://rest.apizza.net/"

        fun <T> getServiceByMain(service: Class<T>, baseUrl: String = BASE_URL): T {
            if (!retrofitMap.containsKey(baseUrl)) {
                val client = OkHttpClient.Builder().addInterceptor(RequestInterceptor()).addInterceptor(LoggingInterceptor()).build()
                val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                retrofitMap[baseUrl] = retrofit
            }

            return retrofitMap[baseUrl]!!.create(service)
        }


        fun bodyToString(request: Request): String = try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            copy.body()!!.writeTo(buffer)
            buffer.readUtf8()
        } catch (e: IOException) {
            "did not work"
        }

        // other base url...
    }

    class RequestInterceptor:Interceptor{
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()

            //请求定制(添加请求头)
            val requestBuilder = original.newBuilder()
            val request = requestBuilder.build()

            // 解决响应时崩溃无log问题
            val sbRequest = StringBuffer()
            if (request.method().compareTo("post", ignoreCase = true) == 0) {
                sbRequest.append(bodyToString(request))
            }
            LogUtil.e(TAG, "====请求地址====" + request.url())
            LogUtil.e(TAG, "====请求参数====$sbRequest")

            return chain.proceed(request)
        }
    }

    class LoggingInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()

//            // 解决响应时崩溃无log问题
//            val sbRequest = StringBuffer()
//            if (request.method().compareTo("post", ignoreCase = true) == 0) {
//                sbRequest.append(bodyToString(request))
//            }
//            LogUtil.e(TAG, "====请求地址====" + request.url())
//            LogUtil.e(TAG, "====请求参数====$sbRequest")


            val response = chain.proceed(request)

            var bodyString = response.body()!!.string()
            if (request.url().toString().contains("match_answer") && bodyString.contains("answer_right_total_number")) {
                bodyString = bodyString.replace("\"info\":{", "")
                bodyString = bodyString.substring(0, bodyString.length - 1)
            }
            LogUtil.e(TAG, request.url().toString() + "====返回参数====" + bodyString)

            return response.newBuilder()
                .body(ResponseBody.create(response.body()!!.contentType(), bodyString)).build()
        }
    }
}

// 主Service
object MainService :
    MainApi by Requester.getServiceByMain(MainApi::class.java)

// 登录Service
object LoginService :
    LoginApi by Requester.getServiceByMain(LoginApi::class.java)