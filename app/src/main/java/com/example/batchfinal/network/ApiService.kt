package com.example.batchfinal.network

import com.example.batchfinal.model.LoginResponseModel
import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

//    @POST("register-employer")
//    suspend fun registerApi(@Body jsonObject: JsonObject): RegisterResponseModel

    @POST("employer-login")
    suspend fun loginApi(@Body jsonObject: JsonObject): LoginResponseModel
}