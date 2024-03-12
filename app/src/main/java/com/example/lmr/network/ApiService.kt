package com.example.lmr.network

import com.example.lmr.model.LoginResponseModel
import com.example.lmr.model.request.PostBasicDetailEvent
import com.example.lmr.model.response.AgeGroupResponse
import com.example.lmr.model.response.EventCategoryModelResponse
import com.example.lmr.model.response.EventResponse
import com.example.lmr.model.response.MaximumCapacityModel
import com.example.lmr.model.response.PostEventResponse
import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("api/User")
    suspend fun userLogin(@Body jsonObject: JsonObject): LoginResponseModel

    @POST("api/User/VerifyOTP")
    suspend fun verifyOTPApi(@Body jsonObject: JsonObject): LoginResponseModel

    @GET("api/Events/GetEventCategory")
    suspend fun categoryEventApi(): EventCategoryModelResponse

    @GET("api/Events/GetEventType")
    suspend fun EventTypeApi(): EventResponse

    @GET("api/Events/GetTotalMaximumCapacity")
    suspend fun maximumCapacityApi(): MaximumCapacityModel

    @GET("api/Events/GetAgeGroup")
    suspend fun ageApi(): AgeGroupResponse

    @POST("api/Events")
    suspend fun postEvent(@Body mPostData: PostBasicDetailEvent): PostEventResponse

    @GET("/api/Events/GetTotalMaximumCapacity")
    suspend fun getTotalMaximumCapacityApi(@Body jsonObject: JsonObject): LoginResponseModel

    @GET("/api/Events/GetEventorganizerType")
    suspend fun getEventorganizerTypeApi(@Body jsonObject: JsonObject): LoginResponseModel

    @GET("/api/Events/GetEventType")
    suspend fun getEventTypeApi(@Body jsonObject: JsonObject): LoginResponseModel

    @GET("/api/Events/GetEventCategory")
    suspend fun getEventCategoryApi(@Body jsonObject: JsonObject): LoginResponseModel

    @POST("/api/Events/EventPost")
    suspend fun eventPostApi(@Body jsonObject: JsonObject): LoginResponseModel

    @POST("/api/Events/AddTicketingDetails")
    suspend fun addTicketingDetailsApi(@Body jsonObject: JsonObject): LoginResponseModel

    @POST("/api/Events/AddTicketDetails")
    suspend fun addTicketDetailsApi(@Body jsonObject: JsonObject): LoginResponseModel

    @POST("/api/Events/AddTeamMeber")
    suspend fun addTeamMeberApi(@Body jsonObject: JsonObject): LoginResponseModel

    @POST("/api/Events/AddEventOrganizer")
    suspend fun addEventOrganizerApi(@Body jsonObject: JsonObject): LoginResponseModel

    @POST("/api/Events/AddLocation")
    suspend fun addLocationApi(@Body jsonObject: JsonObject): LoginResponseModel

    @POST("/api/Events/AddDateAndTimeDetails")
    suspend fun addDateAndTimeDetailsApi(@Body jsonObject: JsonObject): LoginResponseModel

    @POST("/api/Events/AddDateAndTime")
    suspend fun addDateAndTimeApi(@Body jsonObject: JsonObject): LoginResponseModel

    @POST("/api/Events/AddDescription")
    suspend fun addDescriptionApi(@Body jsonObject: JsonObject): LoginResponseModel

    @GET("/api/Events")
    suspend fun eventsApi(@Body jsonObject: JsonObject): LoginResponseModel

    @GET("/api/Country")
    suspend fun countryApi(@Body jsonObject: JsonObject): LoginResponseModel
}