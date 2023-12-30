package com.example.batchfinal.network.errorhandling

interface ErrorHandler {
    fun getErrorMessageFrom(ex: Exception): String?
}