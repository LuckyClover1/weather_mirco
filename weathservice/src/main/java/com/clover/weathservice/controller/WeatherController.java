package com.clover.weathservice.controller;

import com.clover.weathservice.entity.WeatherData;
import com.clover.weathservice.entity.WeatherResponse;
import com.clover.weathservice.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "/weather/cityId/{cityId}")
    public WeatherResponse getWeather(@PathVariable("cityId") String cityId){
        WeatherResponse weatherResponseAqi = weatherService.getAqiWeatherByCityId(cityId);
        WeatherResponse weatherResponseForecast =  weatherService.getForcastWeatherByCityId(cityId);
        WeatherResponse weatherResponseCondition =  weatherService.getWeatherByCityId(cityId);

        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setCode("200");
        weatherResponse.setData(new WeatherData());
        weatherResponse.setMsg("sucess");
        weatherResponse.getData().setAqi(weatherResponseAqi.getData().getAqi());
        weatherResponse.getData().setForecast(weatherResponseForecast.getData().getForecast());
        weatherResponse.getData().setCondition(weatherResponseCondition.getData().getCondition());
        weatherResponse.getData().setCity(weatherResponseAqi.getData().getCity());
        return weatherResponse;
    }
}
