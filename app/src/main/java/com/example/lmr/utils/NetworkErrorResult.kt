package com.example.lmr.utils

sealed class NetworkErrorResult<T>(var data: T? = null, val message: String? = null) {
//    object Loading : NetworkErrorResult<T>()
//class Loading : NetworkErrorResult<T>("")

    class Success<T>(data: T? = null): NetworkErrorResult<T>(data=data)
    class Error<T>(message: String? =null) : NetworkErrorResult<T>(message=message)
      class Loading<T>() : NetworkErrorResult<T>()

}