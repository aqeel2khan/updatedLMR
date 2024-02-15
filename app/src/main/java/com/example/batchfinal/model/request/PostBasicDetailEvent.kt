package com.example.batchfinal.model.request

import com.google.gson.annotations.SerializedName

data class PostBasicDetailEvent
(
    @SerializedName("eventBasicDetailsID") val eventBasicDetailsID: Int,
    @SerializedName("eventID") val eventID: Int,
    @SerializedName("eventName") val eventName: String,
    @SerializedName("eventTypeID") val eventTypeID: Int,
    @SerializedName("eventCategoryID") val eventCategoryID: Int,
    @SerializedName("numberOfPeople") val numberOfPeople: Int,
    @SerializedName("maximumCapacity") val maximumCapacity: Int,
    @SerializedName("publishingMethod") val publishingMethod: Int,
    @SerializedName("ticketType") val ticketType: Int,
    @SerializedName("ageGroupID") val ageGroupID: Int
)