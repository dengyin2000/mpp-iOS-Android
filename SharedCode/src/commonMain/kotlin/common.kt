package org.kotlin.mpp.mobile

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON

expect fun httpGet(url:String):String


fun <T> convertJsonToObject(jsonString: String, serializer:DeserializationStrategy<T>):T {
    return JSON(strictMode = false).parse(serializer, jsonString)
}

fun getGuangZhouWeather():CityWeather {
    val jsonString = httpGet("http://t.weather.sojson.com/api/weather/city/101280101")
    println("jsonString: $jsonString")
    return convertJsonToObject(jsonString, CityWeather.serializer())
}

@Serializable
data class CityWeather(
        var time: String,
        var date: String,
        var message: String,
        var status: String,
        var cityInfo:CityInfo,
        var data: WeatherData

)

@Serializable
data class WeatherData(
        var shidu: String,
        var pm25: String,
        var pm10: String,
        var quality: String,
        var wendu: String,
        var ganmao: String,
        var yesterday:DayInfo,
        var forecast:MutableList<DayInfo>


)

@Serializable
data class DayInfo(
        var date:String,
        var sunrise:String,
        var high:String,
        var low:String,
        var sunset:String,
        var aqi:String,
        var fx:String,
        var fl:String,
        var type:String,
        var notice:String
)

@Serializable
data class CityInfo(
        var city:String,
        var cityId:String,
        var parent:String,
        var updateTime:String
)