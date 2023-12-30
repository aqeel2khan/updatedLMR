package com.example.batchfinal.out

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseViewModell(
    private val repository: BaseRepository
) : ViewModel() {

    //suspend fun logout() = withContext(Dispatchers.IO) { repository.logout() }

}