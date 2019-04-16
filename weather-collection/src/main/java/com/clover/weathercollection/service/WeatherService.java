package com.clover.weathercollection.service;

public interface WeatherService {
    //实况
    void getWeatherByCityId(String cityId);
    //空气质量
    void getAqiWeatherByCityId(String cityId);
    //预测3天天气
    void getForcastWeatherByCityId(String cityId);
}
