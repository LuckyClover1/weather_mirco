package com.clover.cityserver.controller;

import com.clover.cityserver.entity.CityVo;
import com.clover.cityserver.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/cities")
    public List<CityVo> cities(){
        return cityService.cityList();
    }

    @RequestMapping(value = "/cities/{name}")
    public List<CityVo> citiesByName(@PathVariable("name") String name){
        return cityService.cityListOfProvince(name);
    }
}
