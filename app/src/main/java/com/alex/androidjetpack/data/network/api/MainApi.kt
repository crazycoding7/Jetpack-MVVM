package com.alex.androidjetpack.data.network.api

import com.alex.androidjetpack.data.model.BaseResponse
import retrofit2.http.GET

interface MainApi {
    @GET("/mock/ba52c77a7eedae1792f1140308bbe400/messages")
    suspend fun getMainData(): BaseResponse
}