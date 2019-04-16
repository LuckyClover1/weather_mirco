package com.clover.weatherreport.service;

import com.clover.weatherreport.feign.FeignInterface;
import com.clover.weatherreport.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private FeignInterface feignInterface;
    @Override
    public WeatherResponse weatherData(String cityId) {
        return feignInterface.weatherData(cityId);
    }
}
