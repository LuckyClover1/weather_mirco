package com.clover.base.weatherService;

import com.clover.base.entity.WeatherResponse;

public interface WeatherService {
    //实况
    WeatherResponse getWeatherByCityId(String cityId);
    //空气质量
    WeatherResponse getAqiWeatherByCityId(String cityId);
    //预测3天天气
    WeatherResponse getForcastWeatherByCityId(String cityId);
}
