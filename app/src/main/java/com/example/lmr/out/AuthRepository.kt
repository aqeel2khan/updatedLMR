package com.example.lmr.out

import com.example.lmr.network.ApiService
import com.google.gson.JsonObject

import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: ApiService,
) : BaseRepository(api) {

    suspend fun loginApi(jsonObject: JsonObject)= safeApiCall {
        api.verifyOTPApi(jsonObject)
    }
    suspend fun registerApi(jsonObject: JsonObject)= safeApiCall {
        api.verifyOTPApi(jsonObject)
    }
}