package com.clover.base.controller;

import com.clover.base.entity.WeatherResponse;
import com.clover.base.weatherService.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "/weather/cityId/{cityId}")
    public ModelAndView getWeather(@PathVariable("cityId") String cityId, @RequestParam("type") String weatherType,Model model){
        WeatherResponse weatherResponse = null;
        switch(weatherType){
            case "aqi" : {
                weatherResponse = weatherService.getAqiWeatherByCityId(cityId);
                break;
            }
            case "forecast" : {
                weatherResponse =  weatherService.getForcastWeatherByCityId(cityId);
                break;
            }
            default: {
                weatherResponse =  weatherService.getWeatherByCityId(cityId);
                break;
            }
        }

        model.addAttribute("weather",weatherResponse.getData());
        return new ModelAndView("home","data",model);
    }
}
