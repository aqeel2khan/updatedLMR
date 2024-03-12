package com.example.lmr.out

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.lmr.model.LoginResponseModel
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.simplifiedcoding.data.network.Resource

import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : BaseViewModell(repository) {
    // Login Api
    private val _loginResponse: MutableLiveData<Resource<LoginResponseModel>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponseModel>>
        get() = _loginResponse

    fun login(
        jsonObject: JsonObject
    ) = viewModelScope.launch {
        _loginResponse.value = Resource.Loading
        _loginResponse.value = repository.loginApi(jsonObject)
    }
}