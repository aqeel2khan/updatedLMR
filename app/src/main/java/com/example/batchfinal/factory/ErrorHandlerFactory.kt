package com.example.batchfinal.factory

import com.example.batchfinal.di.Http
import com.example.batchfinal.di.PreLogin
import com.example.batchfinal.model.RequestType
import com.example.batchfinal.network.errorhandling.ErrorHandler
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