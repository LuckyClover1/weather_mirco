package com.clover.weatherreport.feign;

import com.clover.weatherreport.vo.City;
import com.clover.weatherreport.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("weather-zuul")
public interface FeignInterface {
    @RequestMapping(value="/data/weather/cityId/{cityId}")
    public WeatherResponse weatherData(@PathVariable("cityId") String cityId);

    @RequestMapping(value = "/city/cities/{name}")
    public List<City> cities(@PathVariable("name") String name);
}
