package com.example.batchfinal.repository

import com.example.batchfinal.model.request.PostBasicDetailEvent
import com.example.batchfinal.model.response.AgeGroupResponse
import com.example.batchfinal.model.response.EventCategoryModelResponse
import com.example.batchfinal.model.response.EventResponse
import com.example.batchfinal.model.response.MaximumCapacityModel
import com.example.batchfinal.model.response.PostEventResponse
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



    suspend fun getEventType(): Flow<NetworkErrorResult<EventResponse>> {
        return flow {
            emit(safeApiCall { apiService.EventTypeApi() })
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getmaximumCapacity(): Flow<NetworkErrorResult<MaximumCapacityModel>> {
        return flow {
            emit(safeApiCall { apiService.maximumCapacityApi() })
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAge(): Flow<NetworkErrorResult<AgeGroupResponse>> {
        return flow {
            emit(safeApiCall { apiService.ageApi() })
        }.flowOn(Dispatchers.IO)
    }

    suspend fun postEventData(mPostBasicDetailEvent: PostBasicDetailEvent): Flow<NetworkErrorResult<PostEventResponse>> {
        return flow {
            emit(safeApiCall { apiService.postEvent(mPostBasicDetailEvent) })
        }.flowOn(Dispatchers.IO)
    }
}