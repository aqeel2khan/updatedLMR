package com.example.batchfinal.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.batchfinal.model.response.EventCategoryModelResponse
import com.example.batchfinal.repository.BasicDetailRepository
import com.example.batchfinal.utils.NetworkErrorResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasicDetailViewModel @Inject constructor(
    private val basicDetailRepository: BasicDetailRepository
) : BaseViewModel() {

    var _eventcategoryResponse: MutableLiveData<NetworkErrorResult<EventCategoryModelResponse>> = MutableLiveData()

    // Create Event Model Response
    val eventcategoryResponse: MutableLiveData<NetworkErrorResult<EventCategoryModelResponse>>
        get() = _eventcategoryResponse

    fun getCategoryEvents() = viewModelScope.launch {

         basicDetailRepository.getCategoryEvent().collect(){values ->
             _eventcategoryResponse.value =NetworkErrorResult.Loading()
             _eventcategoryResponse.value = values
         }
    }


}