
package com.example.lmr.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.lmr.model.LoginResponseModel
import com.example.lmr.repository.DateTimeRepository
import com.example.lmr.utils.NetworkErrorResult
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DateTimeViewModel @Inject constructor(
    private val userRepo: DateTimeRepository
): BaseViewModel() {
    // Login Api
    var _loginResponse: MutableLiveData<NetworkErrorResult<LoginResponseModel>> = MutableLiveData()

    // Create Event Model Response
    val loginResponse: LiveData<NetworkErrorResult<LoginResponseModel>>
        get() = _loginResponse

    fun loginApiCall(jsonObject: JsonObject) = viewModelScope.launch {
        userRepo.addDateAndTimeApi(jsonObject).collect { values ->
            _loginResponse.value = values
        }
    }
    fun callPostEvent(jsonObject: JsonObject) = viewModelScope.launch {
        userRepo.addDateAndTimeApi(jsonObject)
    }
}