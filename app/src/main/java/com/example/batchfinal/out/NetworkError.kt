package com.in10mServiceMan.ui.viewmodel.out

sealed class NetworkError<out T> {
    data class Success<out T>(val value: T) : NetworkError<T>()
    data class Failure(
        val isNetworkError: String,
        val errorCode: Int?,
        val errorBody: String?
    ) : NetworkError<Nothing>()
    object Loading : NetworkError<Nothing>()
}