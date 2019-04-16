package com.clover.weatherreport.controller;

import com.clover.weatherreport.service.CityService;
import com.clover.weatherreport.service.WeatherReportService;
import com.clover.weatherreport.vo.City;
import com.clover.weatherreport.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class WeatherReportController {
    @Autowired
    private WeatherReportService weatherReportService;
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/weather/cityId/{cityId}")
    public ModelAndView weather(@PathVariable("cityId") String cityId, @NotNull Model model){
        List<City> cityList = cityService.cities();
        WeatherResponse weatherResponse = weatherReportService.weatherData(cityId);
        model.addAttribute("condition",weatherResponse.getData().getCondition());
        model.addAttribute("aqi",weatherResponse.getData().getAqi());
        model.addAttribute("forecast",weatherResponse.getData().getForecast());
        model.addAttribute("cityList",cityList);
        model.addAttribute("city",weatherResponse.getData().getCity());

        return new ModelAndView("home","data",model);
    }
}
