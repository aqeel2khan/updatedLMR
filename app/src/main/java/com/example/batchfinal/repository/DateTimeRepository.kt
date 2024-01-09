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

class DateTimeRepository @Inject constructor(private val apiService: ApiService) : BaseApiResponse() {
    suspend fun addDateAndTimeApi(jsonObject: JsonObject): Flow<NetworkErrorResult<LoginResponseModel>> {
        return flow {
            emit(safeApiCall { apiService.addDateAndTimeApi(jsonObject) })
        }.flowOn(Dispatchers.IO)
    }

    suspend fun addDateAndTimeDetailsApi(jsonObject: JsonObject): Flow<NetworkErrorResult<LoginResponseModel>> {
        return flow {
            emit(safeApiCall { apiService.addDateAndTimeDetailsApi(jsonObject) })
        }.flowOn(Dispatchers.IO)
    }
}