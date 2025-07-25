package com.example.weatherapp.model.forecast

import com.example.weatherapp.model.weather.Coord
import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("crood") var crood: Coord? = Coord(),
    @SerializedName("country") var country: String? = null,
    @SerializedName("population") var population: Int? = null,
    @SerializedName("timezone") var timezone: Int? = null,
    @SerializedName("sunrise") var sunrise: Int? = null,
    @SerializedName("sunset") var sunset: Int? = null,
)