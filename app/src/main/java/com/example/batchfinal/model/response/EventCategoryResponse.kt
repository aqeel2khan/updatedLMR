package com.example.batchfinal.model.response

import com.google.gson.annotations.SerializedName

data class EventCategoryModelResponse(
    @SerializedName("message") val message: String,
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: List<EventCategory>
)

data class EventCategory(
    @SerializedName("eventTypeID") val eventTypeID: Int,
    @SerializedName("eventTypeNameEnglish") val eventTypeNameEnglish: String,
    @SerializedName("eventTypeNameArabic") val eventTypeNameArabic: String,
    @SerializedName("language") val language: String
)