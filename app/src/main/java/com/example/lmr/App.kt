package com.example.lmr

import android.app.Application
import com.example.lmr.network.ApiService
import com.example.lmr.repository.UserRepository
import com.example.lmr.retrofilt.RetrofitHelper
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