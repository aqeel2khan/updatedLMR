package com.example.lmr.model.response

import com.google.gson.annotations.SerializedName

data class EventCategoryModelResponse(
    @field:SerializedName("message") val message: String,
    @field:SerializedName("success") val success: Boolean,
    @field:SerializedName("data") val data: MutableList<EventCategory>
)
data class EventCategory(
    @field:SerializedName("eventCategoryID") val eventTypeID: Int,
    @field:SerializedName("eventCategoryNameEnglish") val eventTypeNameEnglish: String,
    @field:SerializedName("eventCategoryNameArabic") val eventTypeNameArabic: String,
    @field:SerializedName("language") val language: String
)