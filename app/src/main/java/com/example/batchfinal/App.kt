package com.example.batchfinal

import android.app.Application
import com.example.batchfinal.network.ApiService
import com.example.batchfinal.repository.UserRepository
import com.example.batchfinal.retrofilt.RetrofitHelper
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App: Application() {
    lateinit var repository: UserRepository

    override fun onCreate() {
        super.onCreate()
        // Initialize timber to provide logging without need to add TAG to logs
        Timber.plant(Timber.DebugTree())
       // initialize()
    }
    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(ApiService::class.java)
        repository= UserRepository(quoteService)

    }
}