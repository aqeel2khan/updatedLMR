package com.example.batchfinal.factory

interface IFactory<T, R> {
    fun create(data: T): R
}