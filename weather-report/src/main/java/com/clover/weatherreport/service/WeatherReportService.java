package com.clover.weatherreport.service;

import com.clover.weatherreport.vo.WeatherResponse;

public interface WeatherReportService {
    public WeatherResponse weatherData(String cityId);

}
