package com.sunnyweather.android.logic.network

import com.google.gson.annotations.SerializedName
import com.sunnyweather.android.logic.model.Location

data class PlaceResponse(val status: String, val places: List<Place>)
data class Place(
    val name: String,
    val location: Location,
    @SerializedName("formatted_address") val address: String
)