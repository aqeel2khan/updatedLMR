package com.example.batchfinal.repository

import com.example.batchfinal.model.response.EventCategoryModelResponse
import com.example.batchfinal.network.ApiService
import com.example.batchfinal.utils.NetworkErrorResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BasicDetailRepository @Inject constructor(private val apiService: ApiService) : BaseApiResponse() {
    suspend fun getCategoryEvent(): Flow<NetworkErrorResult<EventCategoryModelResponse>> {
        return flow {
            emit(safeApiCall { apiService.categoryEventApi() })
        }.flowOn(Dispatchers.IO)
    }
}