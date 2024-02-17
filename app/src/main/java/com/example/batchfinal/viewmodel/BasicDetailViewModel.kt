package com.example.batchfinal.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.batchfinal.model.request.PostBasicDetailEvent
import com.example.batchfinal.model.response.AgeGroupResponse
import com.example.batchfinal.model.response.EventCategoryModelResponse
import com.example.batchfinal.model.response.EventResponse
import com.example.batchfinal.model.response.MaximumCapacityModel
import com.example.batchfinal.model.response.PostEventResponse
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
    var _eventTypeResponse: MutableLiveData<NetworkErrorResult<EventResponse>> = MutableLiveData()

    var _maximumCapacityResponse: MutableLiveData<NetworkErrorResult<MaximumCapacityModel>> = MutableLiveData()
    var _ageGroupResponse: MutableLiveData<NetworkErrorResult<AgeGroupResponse>> = MutableLiveData()

    var _postEventResponse: MutableLiveData<NetworkErrorResult<PostEventResponse>> = MutableLiveData()



    // Create Event Model Response
    val eventcategoryResponse: MutableLiveData<NetworkErrorResult<EventCategoryModelResponse>>
        get() = _eventcategoryResponse

    val eventTypeResponse: MutableLiveData<NetworkErrorResult<EventResponse>>
        get() = _eventTypeResponse

    val maximumCapacityResponse: MutableLiveData<NetworkErrorResult<MaximumCapacityModel>>
        get() = _maximumCapacityResponse

    var ageGroupResponse: MutableLiveData<NetworkErrorResult<AgeGroupResponse>> = MutableLiveData()
        get() = _ageGroupResponse

    var postEventResponse: MutableLiveData<NetworkErrorResult<PostEventResponse>> = MutableLiveData()
        get() = _postEventResponse

    fun getCategoryEvents() = viewModelScope.launch {

         basicDetailRepository.getCategoryEvent().collect(){values ->
             _eventcategoryResponse.value =NetworkErrorResult.Loading()
             _eventcategoryResponse.value = values
         }
    }

    fun getEventsType() = viewModelScope.launch {

        basicDetailRepository.getEventType().collect(){values ->
            _eventTypeResponse.value =NetworkErrorResult.Loading()
            _eventTypeResponse.value = values
        }
    }

    fun getMaximumCapacity() = viewModelScope.launch {

        basicDetailRepository.getmaximumCapacity().collect(){values ->
            _maximumCapacityResponse.value =NetworkErrorResult.Loading()
            _maximumCapacityResponse.value = values
        }
    }

    fun getAgeApi() = viewModelScope.launch {

        basicDetailRepository.getAge().collect(){values ->
            _ageGroupResponse.value =NetworkErrorResult.Loading()
            _ageGroupResponse.value = values
        }
    }

    fun postEventData(mPostBasicDetailEvent: PostBasicDetailEvent) = viewModelScope.launch {

        basicDetailRepository.postEventData(mPostBasicDetailEvent).collect(){values ->
            postEventResponse.value =NetworkErrorResult.Loading()
            postEventResponse.value = values
        }
    }


}