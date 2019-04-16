package com.clover.base;

import com.clover.base.weatherService.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityListTest {
    @Autowired
    CityService cityService;
    @Test
    public void testCityList(){
        cityService.cityList();
    }
}
