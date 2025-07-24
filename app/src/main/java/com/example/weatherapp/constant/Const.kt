package com.example.weatherapp.constant

class Const {
    companion object {
        var permissions = arrayOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )

        const val openWeatherMapApiKey = "dae95262b2ac7bbf3b72bb2614a8973d"

        const val colorBg1 = 0xFF08203E
        const val colorBg2 = 0xFF557C93

        const val LOADING = "Loading..."
        const val NA = "N/A"
    }
}