package com.example.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.Locale

class Utils {
    companion object {
        fun timestampToHumanDate(timestamp: Long, format: String): String {
            val sdf = SimpleDateFormat(format, Locale.US)
            return sdf.format(timestamp * 1000)
        }

        fun buildIcon(icon: String, isBigSize: Boolean = true): String {
            return if(isBigSize) {
                "https://openweathermap.org/img/wn/$icon@4x.png"
            } else {
                "https://openweathermap.org/img/wn/$icon.png"
            }
        }
    }
}