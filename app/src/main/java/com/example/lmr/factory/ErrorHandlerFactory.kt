package com.example.lmr.factory

import com.example.lmr.di.Http
import com.example.lmr.di.PreLogin
import com.example.lmr.model.RequestType
import com.example.lmr.network.errorhandling.ErrorHandler
import javax.inject.Inject

class ErrorHandlerFactory @Inject constructor(
    @Http private val httpErrorHandler: ErrorHandler,
    @PreLogin private val preLoginErrorHandler: ErrorHandler
): IFactory<RequestType, ErrorHandler> {
    override fun create(data: RequestType): ErrorHandler {
        return when(data)
        {
            RequestType.POST_LOGIN -> {
                httpErrorHandler
            }
            RequestType.PRE_LOGIN -> {
                preLoginErrorHandler
            }
        }
    }
}