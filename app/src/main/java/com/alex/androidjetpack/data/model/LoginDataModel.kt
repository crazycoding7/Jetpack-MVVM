package com.alex.androidjetpack.data.model

data class LoginDataModel(
    val code: Int,
    val message: String,
    val data: LoginData
) : BaseModelInterface {
    fun isSuccess(): Boolean = code == 200
}

data class LoginData(
    val token: String,
    val user_id: String,
    val name:String,
    val age:Int
) : BaseModelInterface
