package com.example.lmr.network.errorhandling

interface ErrorHandler {
    fun getErrorMessageFrom(ex: Exception): String?
}