package com.example.batchfinal.utils

sealed class NetworkErrorResult<T>(var data: T? = null, val message: String? = null) {
    class Loading<T> : NetworkErrorResult<T>()
    class Success<T>(data: T? = null):NetworkErrorResult<T>(data=data)
    class Error<T>(message: String? =null) : NetworkErrorResult<T>(message=message)

}