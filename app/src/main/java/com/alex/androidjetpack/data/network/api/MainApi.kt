package com.alex.androidjetpack.data.network.api

import com.alex.androidjetpack.data.model.BaseResponse
import retrofit2.http.GET

interface MainApi {
    @GET("messages")
    suspend fun getMainData(): BaseResponse
}