package com.example.batchfinal.repository

import com.example.batchfinal.model.LoginResponseModel
import com.example.batchfinal.network.ApiService
import com.example.batchfinal.utils.NetworkErrorResult
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService) : BaseApiResponse() {
    suspend fun loginApi(jsonObject: JsonObject): Flow<NetworkErrorResult<LoginResponseModel>> {
        return flow {
            emit(safeApiCall { apiService.verifyOTPApi(jsonObject) })
        }.flowOn(Dispatchers.IO)
    }
}