package com.clover.weathservice.service;

import com.clover.weathservice.entity.WeatherResponse;

public interface WeatherService {
    //实况
    WeatherResponse getWeatherByCityId(String cityId);
    //空气质量
    WeatherResponse getAqiWeatherByCityId(String cityId);
    //预测3天天气
    WeatherResponse getForcastWeatherByCityId(String cityId);
}
