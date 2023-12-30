package com.example.batchfinal.out

import com.example.batchfinal.network.ApiService
import net.simplifiedcoding.data.network.SafeApiCall

abstract class BaseRepository(private val api: ApiService) : SafeApiCall {

    /*suspend fun logout() = safeApiCall {
        api.logout()
    }*/
}