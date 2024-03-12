package com.example.lmr.out

import com.example.lmr.network.ApiService
import net.simplifiedcoding.data.network.SafeApiCall

abstract class BaseRepository(private val api: ApiService) : SafeApiCall {

    /*suspend fun logout() = safeApiCall {
        api.logout()
    }*/
}