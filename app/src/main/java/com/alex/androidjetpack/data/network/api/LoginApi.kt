package com.alex.androidjetpack.data.network.api

import com.alex.androidjetpack.data.model.LoginDataModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApi {

    @FormUrlEncoded
    @POST("/mock/ba52c77a7eedae1792f1140308bbe400/login")
    suspend fun login(@Field("username") username: String, @Field("password") password: String): LoginDataModel
}