package com.clover.weatherreport.service;

import com.clover.weatherreport.feign.FeignInterface;
import com.clover.weatherreport.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private FeignInterface feignInterface;
    @Override
    public List<City> cities() {
        return feignInterface.cities("a");
    }
}
