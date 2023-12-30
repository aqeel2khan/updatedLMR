package com.example.batchfinal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.batchfinal.repository.UserRepository


class MainViewModelFactory (private val repository: UserRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AllViewModel(repository) as T
    }

}