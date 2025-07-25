package com.example.weatherapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weatherapp.constant.Const.Companion.NA
import com.example.weatherapp.constant.Const.Companion.cardColor
import com.example.weatherapp.model.forecast.ForecastResult
import com.example.weatherapp.utils.Utils.Companion.buildIcon
import com.example.weatherapp.utils.Utils.Companion.timestampToHumanDate
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ForecastSection(forecastResponse: ForecastResult) {
    return Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        forecastResponse.list?.let { listForecast ->
            if (listForecast.size > 0) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(listForecast) { currentItem ->
                        currentItem.let { item ->
                            var temp = ""
                            var icon = ""
                            var time = ""

                            item.main.let { main ->
                                temp = if (main == null) NA else "${main.temp}°C"
                            }

                            item.weather.let { weather ->
                                icon = if (weather == null) NA else buildIcon(
                                    weather[0].icon!!,
                                    isBigSize = false
                                )
                            }

                            item.dt?.let { dateTime ->
                                time = timestampToHumanDate(dateTime.toLong(), "EEE hh:mm a")
                            } ?: run {
                                time = "N/A"
                            }

                            ForecastTitle(temp = temp, image = icon, time = time)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ForecastTitle(temp: String, image: Any, time: String) {
    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(cardColor).copy(alpha = 0.7f),
            contentColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .padding(60.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = temp.ifEmpty { NA },
                color = Color.White
            )

            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp),
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = time.ifEmpty { NA },
                color = Color.White
            )
        }
    }
}